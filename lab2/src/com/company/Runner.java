package com.company;

public class Runner {

    public static void main(String[] args) {

        int N = 10;

        Runnable[] runners = new Runnable[N];
        Thread[] threads = new Thread[N];

        for (int i = 0; i < N; i++) {
            runners[i] = new MyRun(i);
        }

        for (int i = 0; i < N; i++) {
            threads[i] = new Thread(runners[i]);
        }

        for (int i = 0; i < N; i++) {
            threads[i].start();
        }

        try{
            Thread.sleep(10);
            for (int i = 0; i < N; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}