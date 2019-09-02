package cn.andy.life.config;

import cn.andy.life.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类 等于 配置文件
 */
@Configuration
public class PersonConfig {

    /**
     * 给容器注册一个bean组件,类型返回值是id 默认是使用方法名作为id
     * @return
     */
    @Bean("person")
    public Person person() {
        return new Person("李四", "90");
    }
}
