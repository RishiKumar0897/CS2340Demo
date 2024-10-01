package com.example.rishi_2340_demo.model;

public class CounterModel {
    private int counter;
    // add constructor and initialize to 0
    public CounterModel() {
        this.counter  = 0;
    }

    //getCounter()
    public int getCounter() {
        return counter;
    }

    //setter
    public void setCounter(int counter) {
        this.counter = counter;
    }

    //method that increments counter by 1
    public void incrementCounter() {
        counter++;
    }



}
