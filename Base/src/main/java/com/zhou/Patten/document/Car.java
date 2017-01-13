package com.zhou.Patten.document;

import java.util.Map;

/**
 * Created by Administrator on 2017/1/13.
 */
public class Car extends AbstractDocument implements HasType,HasModel,HasPrice {
    public Car(Map<String, Object> properties) {
        super(properties);
    }
}
