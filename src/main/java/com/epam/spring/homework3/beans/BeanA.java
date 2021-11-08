package com.epam.spring.homework3.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BeanA implements InitializingBean, DisposableBean, Bean {
    private String name;
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
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Inside afterPropertiesSet() " + this.getClass().getSimpleName() );
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Inside destroy() " + this.getClass().getSimpleName() );
    }
}
