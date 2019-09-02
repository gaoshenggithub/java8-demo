package cn.andy.life.importbeandefinitionregistrar;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(value = {Andy.class,ImportBeanDefinitionRegistrarConfig.class})
@Configuration
public class AndyConfig {
}
