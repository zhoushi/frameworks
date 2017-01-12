package com.zhou.guava;

import com.google.common.collect.ForwardingSet;

import java.util.Set;

/**
 * Created by Administrator on 2017/1/10.
 */
public class ObservableSet<E> extends ForwardingSet {
    @Override
    protected Set delegate() {
        return null;
    }

    public ObservableSet(Set<E> set){
        super();
    }
}
