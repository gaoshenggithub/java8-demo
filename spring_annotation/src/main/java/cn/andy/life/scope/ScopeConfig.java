package cn.andy.life.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopeConfig {

    /**
     * prototype: 多实例化: ioc容器启动并不会去调用创建对象放入容器中,
     * 每次获取的时候才会调用方法创建
     * singleton: 单实例: ioc容器启动的时候就会创建
     * session: 同一个session创建同一个实例
     * request: 统一次请求创建一次
     *
     * @return
     */
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean
    public ScopeBean scopeBean() {
        System.out.println("已经初始化");
        return new ScopeBean("123", "123");
    }
}
