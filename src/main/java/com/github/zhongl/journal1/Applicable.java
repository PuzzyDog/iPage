package com.github.zhongl.journal1;

/** @author <a href="mailto:zhong.lunfu@gmail.com">zhongl<a> */
public interface Applicable<T> {
    void apply(Record<T> record);
}
