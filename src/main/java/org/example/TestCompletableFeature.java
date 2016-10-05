package org.example;

import java.util.concurrent.CompletableFuture;

/**
 * Created by fagim on 15.08.16.
 */
public class TestCompletableFeature {

    CompletableFuture<Integer> future;
    public void promiseTestCompose() throws Exception{
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(()->{
            return this.slowInt();
        });

        CompletableFuture<Integer> future2 = future1.thenApplyAsync(this::showIncrement);
        CompletableFuture<Integer> future3 = future1.thenApplyAsync(this::showIncrement);
        CompletableFuture<Integer> combineFuture = future2.thenCombine(future3, (x,y)->x+y);

        System.out.println("result: "+combineFuture.get());

    }

    private Integer showIncrement(Integer integer) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ++integer;
    }

    public Integer slowInt()  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
