package cn.andy.life.lifeCycle2;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

public class AppleCycleBean2 implements InitializingBean, DisposableBean {
    public AppleCycleBean2(){
        System.out.println("构造器");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("销毁");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("生成..");
    }
}
