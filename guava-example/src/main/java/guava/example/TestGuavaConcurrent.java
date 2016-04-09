/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package guava.example;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * <P>
 * Description:TODO
 * </p>
 * @author zhengmiao
 * @version 1.0
 * @Date 2015年7月15日下午5:05:33
 */
public class TestGuavaConcurrent {
    public static void main(String[] args) {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture<String> explosion = service.submit(new Callable() {
            public String call() {
                return "hello world";
            }
        });
        Futures.addCallback(explosion, new FutureCallback() {
            @Override
            public void onFailure(Throwable thrown) {
                System.out.println("failed often");
            }

            @Override
            public void onSuccess(Object result) {
                System.out.println("hahhaa ");

            }

        });

    }

}
