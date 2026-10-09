package org.example.utilits;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class bBuddyBuilder {

    public void bBuddybuild() throws IOException {
        DynamicType.Unloaded<?> dynamicType =
                new ByteBuddy()
                        .subclass(BauClass.class)
                        .method(named("bauMethod"))
                        .intercept(FixedValue.value("I'm Byte Buddy method"))
                        .make();

        System.out.println("=== BEFORE LOAD ===");
        System.out.println(dynamicType.getTypeDescription());
        System.out.println(dynamicType.getBytes().length + " bytes");


        byte[] bytes = dynamicType.getBytes();
        Files.write(
                Path.of("BunnyClass.class"),
                bytes
        );
        /*Class<?> clazz =
                dynamicType
                        .load(BauClass.class.getClassLoader())
                        .getLoaded();

        System.out.println("=== AFTER LOAD ===");
        System.out.println("Class: " + clazz);
        System.out.println("Name: " + clazz.getName());
        System.out.println("Superclass: " + clazz.getSuperclass());


        Object object =
                clazz.getDeclaredConstructor().newInstance();

        System.out.println("Object class: " + object.getClass());


        Object result =
                clazz.getMethod("bauMethod")
                        .invoke(object);

        System.out.println("Result: " + result);*/


    }
}
