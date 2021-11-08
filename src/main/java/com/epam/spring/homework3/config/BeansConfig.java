package com.epam.spring.homework3.config;

import com.epam.spring.homework3.beans.BeanB;
import com.epam.spring.homework3.beans.BeanC;
import com.epam.spring.homework3.beans.BeanD;
import com.epam.spring.homework3.beans.BeanF;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.epam.spring.homework3.beans")
@PropertySource("classpath:application.properties")
public class BeansConfig {
    @Bean(
            initMethod = "customInitMethod",
            destroyMethod = "customDestroyMethod"
    )
    @DependsOn({"beanD"})
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean(
            initMethod = "customInitMethod",
            destroyMethod = "customDestroyMethod"
    )
    @DependsOn({"beanB"})
    public BeanC beanC() {
        return new BeanC();
    }

    @Bean(
            initMethod = "customInitMethod",
            destroyMethod = "customDestroyMethod"
    )
    public BeanD beanD() {
        return new BeanD();
    }

    @Bean
    @Lazy
    public BeanF beanF() {
        return new BeanF();
    }
}
