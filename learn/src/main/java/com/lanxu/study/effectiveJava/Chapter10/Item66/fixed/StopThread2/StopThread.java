package com.lanxu.study.effectiveJava.Chapter10.Item66.fixed.StopThread2;// Cooperative thread
// termination with a volatile field

import java.util.concurrent.*;

public class StopThread {
    private static volatile boolean stopRequested;

    public static void main(String[] args)
            throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!stopRequested)
                    i++;
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
