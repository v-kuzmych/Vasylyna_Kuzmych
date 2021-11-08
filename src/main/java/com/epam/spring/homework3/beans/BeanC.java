package com.epam.spring.homework3.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanC implements Bean {
    @Value("${beanC.name}")
    private String name;

    @Value("${beanC.value}")
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
        return "BeanC{" +
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
