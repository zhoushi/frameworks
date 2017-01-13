package com.zhou.Patten.document;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/1/13.
 */
public interface Document {


    Void put(String key,Object value);

    Object get(String key);

    /**
     * 得到stream of child documents
     */
    <T> Stream<T> children(String key, Function<Map<String,Object>,T> constructor);
}
