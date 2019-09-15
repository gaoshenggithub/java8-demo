package cn.andy.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 1.将业务逻辑组件和切面类都加入到容器里面,告诉Spring那个是切面类(@Aspect)
 * 2.在切面类上面标注注解通知注解,告诉Spring何时何地运行
 * 3.开启基于注解AOP模式.@EnableAspectJAutoProxy
 *
 *  原理
 * @EnableAspectJAutoProxy
 *  @Import(AspectJAutoProxyRegistrar.class) 给容器导入组件
 *      给容器注册一个 AnnotationAwareAspectJAutoProxyCreator
 *      2.AnnotationAwareAspectJAutoProxyCreator
 *          ->AnnotationAwareAspectJAutoProxyCreator
 *              ->AspectJAwareAdvisorAutoProxyCreator
 *                  ->AbstractAdvisorAutoProxyCreator
 *                      ->AbstractAutoProxyCreator
 *                          implements SmartInstantiationAwareBeanPostProcessor
 *                          关注后置处理器(在bean初始化,前后做事情,)自动装配BeanFactory
 */
@EnableAspectJAutoProxy
@Configuration
public class ConfigTest {

    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }

    @Bean
    public MatchTest matchTest() {
        return new MatchTest();
    }
}
