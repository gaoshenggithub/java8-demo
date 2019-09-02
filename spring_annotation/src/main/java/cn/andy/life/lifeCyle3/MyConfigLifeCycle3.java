package cn.andy.life.lifeCyle3;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigLifeCycle3 {
    @Bean
    public AppleCycleBean3 appleCycleBean3(){
        return new AppleCycleBean3();
    }
}
