package com.spryng.Models;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spryng.Utils.SkipSerialization;

import java.io.Serializable;

public abstract class BaseObject implements Serializable {
    public static final Gson PRETTY_PRINT_JSON = new GsonBuilder()
            .addSerializationExclusionStrategy(new ExclusionStrategy() {
                @Override
                public boolean shouldSkipField(FieldAttributes f) {
                    return f.getAnnotation(SkipSerialization.class) != null;
                }

                @Override
                public boolean shouldSkipClass(Class<?> clazz) {
                    return false;
                }
            })
            .setPrettyPrinting()
            .create();

    @Override
    public String toString()
    {
        return String.format(
                "<%s@%s> JSON: %s",
                this.getClass().getName(),
                System.identityHashCode(this),
                this.toJson()
        );
    }

    public String toJson()
    {
        return PRETTY_PRINT_JSON.toJson(this);
    }
}
