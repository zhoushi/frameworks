package com.zhou.Patten.asyncMethodInvocation;

import java.util.Optional;

/**
 * Created by Administrator on 2017/1/13.
 */
public interface AsyncCallback<T> {

    void onComplete(T value, Optional<Exception> ex);
}
