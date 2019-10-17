package com.company;

public class Producent implements Runnable{
    ProducentConsumer pc;
    Producent(ProducentConsumer pc){
        this.pc = pc;
    }

    @Override
    public void run() {
        while(true)
        pc.increment();
    }
}
