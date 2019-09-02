package cn.andy.life.beanfactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppleConfig {

    @Bean
    public AppleFactoryBean appleFactoryBean() {
        return new AppleFactoryBean();
    }
}
