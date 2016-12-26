package com.example.raojian.mylibrary;

import android.util.Log;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Administrator on 2016/12/14.
 */

public class TestJar<T> {
    public T clazz;

    public TestJar(T clazz) {
        this.clazz = clazz;
//        Type type = ((ParameterizedType)clazz.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Object o = clazz.getClass().getGenericSuperclass();
        Class<T> c = (Class<T>) clazz.getClass();

        Gson g = new Gson();
        g.fromJson("", c);
    }

    public void printLog() {
        Log.e("raojian", "printLog");
        Gson gson  = new Gson();
        Log.e("raojian", gson.toString());
    }
}
