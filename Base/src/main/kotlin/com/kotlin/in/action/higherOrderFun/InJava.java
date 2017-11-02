package com.kotlin.in.action.higherOrderFun;

import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

import java.util.ArrayList;
import java.util.List;

public class InJava {

   public static void main(String[] args) {
       System.out.println(StatementKt.getSum().invoke(1, 2));
       //   Java 中可以直接使用 Lambda，不过是 Java 8 以上
       StatementKt.processTheAnswer(integer -> integer * 2);
       //   另一个中 8 以下的方式
       StatementKt.processTheAnswer(new Function1<Integer, Integer>() {
           @Override
           public Integer invoke(Integer integer) {
               return integer + 3;
           }
       });

       List<String> strings = new ArrayList<>();
       strings.add("42");
       //   调用 Kotlin 中的标准库函数
       CollectionsKt.forEach(strings, s -> {
           System.out.println(s);
           //   必须显示的返回一个 Unit 类型的值
           return Unit.INSTANCE;
       });
   }
}
