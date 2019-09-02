package cn.andy.life.beanpostprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * * BeanPostProcessor[interface] : bean 的后置处理器;
 * * 在bean初始化前后进行一些处理工作;
 * * postProcessBeforeInitialization: 初始化之前工作
 * * postProcessAfterInitialization: 初始化之后工作
 */
@Component
public class MyBeanPostProcess implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("销毁");
        return bean;
    }
}
