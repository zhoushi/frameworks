package com.zhou.simple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/1/11.
 */
public class App {

    public static void main(String[] args){
        ItemQueue queue = new ItemQueue();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i=0;i<2;i++){
            final Producer producer = new Producer(queue,"Producer_"+i);
            executorService.submit(()->{
                while (true){
                    producer.produce();
                }
            });
        }

        for (int i=0;i<3;i++){
            final Consumer consumer = new Consumer(queue,"Consumer_" + i);
            executorService.submit(()->{
                while (true){
                    consumer.consume();
                }
            });
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
            executorService.shutdownNow();
        } catch (InterruptedException e) {
            System.out.println("Error waiting for ExecutorService shutdown");
        }
    }
}
