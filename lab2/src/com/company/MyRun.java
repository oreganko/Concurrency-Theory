package com.company;

public class MyRun implements Runnable {

    private int id;
    static int zmienna = 0;

    public MyRun(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000 ; i++) {
            if (id % 2 == 0)
                synchronized (this){
                    zmienna++;
                }
            else
                synchronized (this){
                    zmienna--;
                }
        }
        try{
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(id + " -- " + zmienna);
    }
}