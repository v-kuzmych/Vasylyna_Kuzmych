package com.epam.spring.homework3;

import com.epam.spring.homework3.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        displayAllBeans(context);
    }

    public static void displayAllBeans(ApplicationContext context) {
        String[] allBeanNames = context.getBeanDefinitionNames();
        for(String beanName : allBeanNames) {
            System.out.println(context.getBean(beanName));
        }
    }
}
