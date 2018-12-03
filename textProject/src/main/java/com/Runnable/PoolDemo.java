package com.Runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 谭志为 on 2018/12/3.
 */
public class PoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i=0;i<5;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        executorService.shutdown();
    }
}
