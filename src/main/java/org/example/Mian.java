package org.example;

/**
 * Created by fagim on 15.08.16.
 */
public class Mian {
    public static void main(String[] args) throws Exception {
        TestCompletableFeature fc = new TestCompletableFeature();
        long time = System.currentTimeMillis();
        fc.promiseTestCompose();
        System.out.println(System.currentTimeMillis()-time);
    }
}
