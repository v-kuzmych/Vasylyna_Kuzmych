package com.epam.spring.homework3.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanB implements Bean {
    @Value("${beanB.name}")
    private String name;

    @Value("${beanB.value}")
    private int value;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    private void customInitMethod(){
        System.out.println("Inside customInitMethod() " + this.getClass().getSimpleName() );
    }

    private void customDestroyMethod(){
        System.out.println("Inside customDestroyMethod() " + this.getClass().getSimpleName() );
    }

    private void otherInitMethod(){
        System.out.println("This is otherInitMethod() " + this.getClass().getSimpleName() );
    }
}
