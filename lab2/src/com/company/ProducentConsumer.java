package com.company;

import java.time.Duration;

public class ProducentConsumer {

    int zmienna = 0;

    public synchronized void increment(){
            while(zmienna > 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
//            synchronized (this) {
                zmienna++;
                System.out.println("Zmienna: " + zmienna);
                notify();
//            }

    }

    public synchronized void decrement(){

//            synchronized (this) {
                while (zmienna <= 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                    zmienna--;
                    System.out.println("Zmienna: " + zmienna);

                notify();

//            }
    }

    public static void main(String[] args) {

        ProducentConsumer pc = new ProducentConsumer();

//        Thread consumer = new Thread(() -> {while (true) pc.decrement();});
//        Thread producent = new Thread(() -> {while (true) {pc.increment();}});


        Thread consumer = new Thread(new Consumer(pc));
        Thread producent = new Thread(new Producent(pc));

//        Runnable[] runners = new Runnable[N];
//        Thread[] threads = new Thread[N];
//
//        for (int i = 0; i < N/2; i++) {
//                int j = i + N/2;
//            runners[i] = new Producer(pc);
//            runners[j] = new Consumer(pc);
//        }
//
//        for (int i = 0; i < N; i++) {
//            threads[i] = new Thread(runners[i]);
//        }

        producent.start();
        consumer.start();


        try {
            producent.join();
            consumer.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
