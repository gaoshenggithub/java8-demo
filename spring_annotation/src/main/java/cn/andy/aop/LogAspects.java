package cn.andy.aop;

import org.aspectj.lang.annotation.*;

@Aspect
public class LogAspects {

    @Pointcut("execution(public Integer cn.andy.aop.MatchTest.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void logStart() {
        System.out.println("除法运行....参数{}");
    }

    @After("pointCut()")
    public void logEnd() {
        System.out.println("除法结束....");
    }

    @AfterReturning("pointCut()")
    public void logReturn() {
        System.out.println("返回通知....");
    }

    @AfterThrowing("pointCut()")
    public void logException() {
        System.out.println("异常通知....");
    }

    @Around("pointCut()")
    public void around() {
        System.out.println("环绕通知....");
    }


    public static void main(String[] args) {
        if (4.0>5.0){
            System.out.println("1");
        }
    }
}
