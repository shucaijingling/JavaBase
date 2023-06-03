package com.shucai.template;

public interface BizHandle<R, T> {

    default void prepare() {

    }

    public R doBiz(T t);
}
