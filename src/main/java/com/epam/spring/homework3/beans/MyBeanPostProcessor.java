package com.epam.spring.homework3.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Bean && (((Bean) bean).getName() == null || ((Bean) bean).getValue() <= 0)){
            System.out.println(beanName + " - IS NOT VALID!");
        }

        return bean;
    }
}
