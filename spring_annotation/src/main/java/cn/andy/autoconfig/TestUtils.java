package cn.andy.autoconfig;


import cn.andy.autoconfig.auto_primary_qualifier.MainConfig;
import cn.andy.autoconfig.auto_primary_qualifier.mapper.UserMapper;
import cn.andy.autoconfig.auto_primary_qualifier.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUtils {

    @Test
    public void auto() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        UserService bean = applicationContext.getBean(UserService.class);
        System.out.println("bean = " + bean);
        UserMapper bean1 = applicationContext.getBean(UserMapper.class);
        System.out.println("bean1 = " + bean1);
    }
}
