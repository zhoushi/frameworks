package com.zhou.Patten.document;

import java.util.Map;

/**
 * Created by Administrator on 2017/1/13.
 */
public class Part extends AbstractDocument implements HasType,HasModel,HasPrice {
    public Part(Map<String, Object> properties) {
        super(properties);
    }
}
