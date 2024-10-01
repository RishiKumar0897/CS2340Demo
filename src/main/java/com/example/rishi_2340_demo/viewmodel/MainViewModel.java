package com.example.rishi_2340_demo.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.rishi_2340_demo.model.CounterModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//manage the data (greeting message and a counter) provide methods to update this data
public class MainViewModel extends ViewModel {
    private final MutableLiveData<String> greetingMessage;
    private final MutableLiveData<Integer> counter;
    //An instance of CounterModel to handle the counter

    private final CounterModel counterModel;
    //firebase database reference
    private DatabaseReference databaseReference;

    public MainViewModel() {
        greetingMessage = new MutableLiveData<>();
        counter = new MutableLiveData<>();
        counterModel = new CounterModel();
        greetingMessage.setValue("Hello World");
        counter.setValue(counterModel.getCounter());
        //initialize firebase database reference
        databaseReference = FirebaseDatabase.getInstance().getReference();

        //read data from Firebase
        databaseReference.child("counter").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    //counter exists, retrieve value
                    Integer firebaseCounter = dataSnapshot.getValue(Integer.class);

                    if (firebaseCounter != null) {
                        counter.setValue(firebaseCounter);
                        counterModel.setCounter(firebaseCounter);
                    }
                }
                else {
                    //counter does not exist, set an initial value
                    counterModel.setCounter(0);
                    counter.setValue(0);
                    databaseReference.child("counter").setValue(0);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                //handle errors

            }
        });
    }

    //provide access to live data objects

    public LiveData<String> getGreetingMessage() {
        return greetingMessage;
    }

    public LiveData<Integer> getCounter() {
        return counter;
    }

    //Behavior Methods - update methods and incrementing counter
    public void updateMessage() {
        greetingMessage.setValue("Hello from MainViewModel");
    }

    public void incrementCounter() {
        counterModel.incrementCounter();
        counter.setValue(counterModel.getCounter());
        //write the updated counter value to Firebase
        databaseReference.child("counter").setValue(counterModel.getCounter());
    }


}
