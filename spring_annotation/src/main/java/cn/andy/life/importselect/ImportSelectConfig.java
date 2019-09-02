package cn.andy.life.importselect;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {MyImportSelect.class})
public class ImportSelectConfig {
}
