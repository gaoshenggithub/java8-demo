package cn.andy.autoconfig.auto_primary_qualifier;

import cn.andy.autoconfig.auto_primary_qualifier.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 1) @Autowired
 *      1): 默认优先按照类型去容器中找对应的组件,applicationContext.getBean()
 *      2): 如果找到多个相同类型的组件,再将属性的名称作为组件的id去查找
 */
@Configuration
@ComponentScan(value = {"cn.andy.autoconfig.auto_primary_qualifier"})
public class MainConfig {

    @Bean("userMapper2")
    public UserMapper userMapper2() {
        UserMapper userMapper = new UserMapper();
        userMapper.setLabel("1");
        return userMapper;
    }
}
