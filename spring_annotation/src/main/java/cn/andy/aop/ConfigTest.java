package cn.andy.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

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
