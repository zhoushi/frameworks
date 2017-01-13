package com.zhou.Patten.document;

import java.util.Optional;

/**
 * Created by Administrator on 2017/1/13.
 */
public interface HasPrice extends Document{

    String PROPERTY = "price";

    default Optional<Number> getPrice() {
        return Optional.ofNullable((Number) get(PROPERTY));
    }
}
