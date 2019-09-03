package cn.andy.properties.value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:/test.properties"})
public class MyConfigProperties {

    @Bean
    public ValueBean valueBean(){
        return new ValueBean();
    }
}
