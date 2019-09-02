package cn.andy.life.lifeCycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * bean的生命周期
 * bean的创建,----初始化,----销毁过程
 * 容器管理bean的生命周期;
 * 我们可以自定义和销毁方法,在容器中bean进行当前生命周期,初始化和销毁
 * <p>
 * 1).指定初始化和销毁方法:
 *      1.>init-method destroy-method
 *      2.>通过让Bean实现InitializingBean(初始化)DisposableBean(销毁)
 *
 *  构建(对象创建)
 *      单实例: 容器每次启动的时候创建对象
 *      多实例: 每次调用的时候创建对象
 *  销毁:
 *      单实例: 容器关闭的时候
 *      多实例: 容器不会管理这个bean ; 容器不会销毁
 *
 */
@Configuration
public class MyConfigLifeCycle {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public AppleCycleBean appleCycleBean() {
        return new AppleCycleBean();
    }
}
