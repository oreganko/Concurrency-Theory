package com.company;

public class Consumer implements Runnable{
    ProducentConsumer pc;
    Consumer(ProducentConsumer pc){
        this.pc = pc;
    }

    @Override
    public void run() {
        while(true)
        pc.decrement();
    }
}