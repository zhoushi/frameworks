package com.zhou.Patten.asyncMethodInvocation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Created by Administrator on 2017/1/13.
 */
public interface AsyncExecutor {

    //
    <T> AsyncResult<T> startProcess(Callable<T> task);

    //
    <T> AsyncResult<T> startProcess(Callable<T> task,AsyncCallback<T> callback);

    //
    <T> T endProcess(AsyncResult<T> asyncResult) throws ExecutionException,InterruptedException;
}
