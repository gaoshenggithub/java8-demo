package cn.andy.life.lifeCyle3;

import org.springframework.stereotype.Component;

@Component
public class AppleCycleBean3 {

    public AppleCycleBean3() {
        System.out.println("创建Apple构造器");
    }


    public void init(){}
}
