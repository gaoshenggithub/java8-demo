package cn.andy.life.lifeCycle2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigLifeCycle2 {
    @Bean
    public AppleCycleBean2 appleCycleBean2(){
        return new AppleCycleBean2();
    }
}
