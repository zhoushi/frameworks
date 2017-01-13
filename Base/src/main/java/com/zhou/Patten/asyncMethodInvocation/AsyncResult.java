package com.zhou.Patten.asyncMethodInvocation;

import java.util.concurrent.ExecutionException;

/**
 * Created by Administrator on 2017/1/13.
 */
public interface AsyncResult<T> {

    //执行状态
    boolean isCompleted();

    //gets the value of comleted async task
    T getValue() throws ExecutionException;

    //阻塞线程知道私有task iscompleted
    void await() throws InterruptedException;
}
