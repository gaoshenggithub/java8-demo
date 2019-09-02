package cn.andy.life.lazy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class LazyConfig {

    /**
     * 懒加载只是对于singleton才有效
     *
     * @return
     */
    @Lazy
    @Bean
    public LazyBean lazyBean() {
        System.out.println("已经加载....");
        return new LazyBean("asd", "asd");
    }
}
