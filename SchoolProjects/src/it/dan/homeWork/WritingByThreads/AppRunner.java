package it.dan.homeWork.WritingByThreads;

import it.dan.homeWork.WritingByThreads.service.MyRunnable;

public class AppRunner {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            MyRunnable runnable = new MyRunnable();
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}

