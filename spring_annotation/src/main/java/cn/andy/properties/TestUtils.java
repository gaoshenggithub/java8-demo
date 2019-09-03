package cn.andy.properties;

import cn.andy.properties.value.MyConfigProperties;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUtils {

    /**
     * 1. @Value
     */
    @Test
    public void value(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfigProperties.class);
        Object valueBean = applicationContext.getBean("valueBean");
        System.out.println("valueBean = " + valueBean);
    }
}
