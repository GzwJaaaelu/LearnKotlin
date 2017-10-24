package com.kotlin.in.mooc.withJava;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

import java.util.ArrayList;

public class SAMInJava {

    //  这里的 Runnable 是一个只有一个方法的接口
    private ArrayList<Runnable> runnables = new ArrayList<>();

    public void addTask(Runnable r) {
        runnables.add(r);
        System.out.println(runnables.size() + " addTask");
    }

    public void removeTask(Runnable r) {
        runnables.remove(r);
        System.out.println(runnables.size() + " removeTask");
    }

    public static void main(String[] args) {
        SAMInKotlin sik = new SAMInKotlin();
        //  但是在 Java 中就不太好用了
        sik.addTask(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                return null;
            }
        });
    }
}

