package cn.andy.life.imports;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {Color.class,Red.class})
public class ImportConfig {
}
