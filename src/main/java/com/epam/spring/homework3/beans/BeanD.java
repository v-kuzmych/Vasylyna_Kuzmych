package com.epam.spring.homework3.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanD implements Bean {
    @Value("${beanD.name}")
    private String name;

    @Value("${beanD.value}")
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
        return "BeanD{" +
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
}
