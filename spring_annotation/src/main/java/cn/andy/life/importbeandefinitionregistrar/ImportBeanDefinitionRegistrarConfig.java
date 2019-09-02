package cn.andy.life.importbeandefinitionregistrar;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class ImportBeanDefinitionRegistrarConfig implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean containsBeanDefinition = registry.containsBeanDefinition("Andy");
        if (containsBeanDefinition) {
            RootBeanDefinition beanDefinition = new RootBeanDefinition(AndyConfig.class);
            registry.registerBeanDefinition("AndyPro",beanDefinition);
        }
    }
}
