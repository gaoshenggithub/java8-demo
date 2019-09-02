package cn.andy.life.lifeCycle;

public class AppleCycleBean {
    public AppleCycleBean(){
        System.out.println("创建对象....");
    }

    public void init(){
        System.out.println("初始化");
    }

    public void destroy(){
        System.out.println("销毁方法");
    }
}
