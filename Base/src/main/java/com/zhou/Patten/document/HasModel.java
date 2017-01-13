package com.zhou.Patten.document;

import java.util.Optional;

/**
 * Created by Administrator on 2017/1/13.
 */
public interface HasModel extends Document {

    String PROPERTY = "model";

    default Optional<String> getModel(){
        return Optional.ofNullable((String)get(PROPERTY));
    }
}
