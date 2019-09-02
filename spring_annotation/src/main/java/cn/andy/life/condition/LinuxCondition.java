package cn.andy.life.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        ClassLoader classLoader = context.getClassLoader();

        Environment environment = context.getEnvironment();

        if (environment.getProperty("os.name").equals("linux")) {
            return true;
        }
        return false;
    }
}
