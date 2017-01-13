package com.zhou.Patten.document;

import java.util.Optional;

/**
 * Created by Administrator on 2017/1/13.
 */
public interface HasType extends Document {

    String PROPERTY = "type";

    default Optional<String> getType() {
        return Optional.ofNullable((String) get(PROPERTY));
    }

}
