package cn.andy.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    @org.junit.Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigTest.class);

        MatchTest bean = applicationContext.getBean(MatchTest.class);
        bean.test(10);
        ((AnnotationConfigApplicationContext) applicationContext).close();
    }
}
