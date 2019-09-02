package cn.andy.life.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
//@Conditional 类的统一设置,当满足条件的时候,这个类的bean才生效
@Configuration
public class ConditionConfig {
    @Bean
    public ConditionBean conditionBean() {
        return new ConditionBean("男", "1234");
    }

    @Conditional(value = WindowCondition.class)
    @Bean("windows")
    public ConditionBean conditionBean01() {
        return new ConditionBean("女", "asdadsd");
    }

    @Conditional(value = LinuxCondition.class)
    @Bean("linux")
    public ConditionBean conditionBean02() {
        return new ConditionBean("女", "123123");
    }


}
