package cn.andy.life;

import cn.andy.life.bean.Person;
import cn.andy.life.beanfactory.AppleConfig;
import cn.andy.life.componentscan.ComponentConfig;
import cn.andy.life.condition.ConditionBean;
import cn.andy.life.condition.ConditionConfig;
import cn.andy.life.config.PersonConfig;
import cn.andy.life.importbeandefinitionregistrar.AndyConfig;
import cn.andy.life.imports.ImportConfig;
import cn.andy.life.importselect.ImportSelectConfig;
import cn.andy.life.lazy.LazyBean;
import cn.andy.life.lazy.LazyConfig;
import cn.andy.life.lifeCycle.AppleCycleBean;
import cn.andy.life.lifeCycle.MyConfigLifeCycle;
import cn.andy.life.lifeCycle2.MyConfigLifeCycle2;
import cn.andy.life.scope.ScopeConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

public class TestUtils {

    /**
     * 1. @Bean
     */
    @Test
    public void bean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println("person = " + person);
    }

    /**
     * 1. @Configuration
     */
    @Test
    public void config() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersonConfig.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);

        /**
         * 获取bean组件的名称
         */
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println("s = " + s);
        }
    }

    /**
     * 2. @ComponentScans @ComponentScan
     */
    @Test
    public void componentscan() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ComponentConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }

    /**
     * 3.@scope
     */
    @Test
    public void scope() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
        Object scopeBean = context.getBean("scopeBean");
        Object scopeBean2 = context.getBean("scopeBean");
        System.out.println("scopeBean = " + scopeBean);
        System.out.println("scopeBean2 = " + scopeBean2);
    }

    /**
     * 4.@Lazy
     */
    @Test
    public void lazy() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(LazyConfig.class);
        LazyBean bean = applicationContext.getBean(LazyBean.class);
        System.out.println("bean = " + bean);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }


    /**
     * 5.@Condition 按照条件注入
     */
    @Test
    public void condition() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConditionConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Environment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println("property = " + property);
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
        Map<String, ConditionBean> beansOfType = applicationContext.getBeansOfType(ConditionBean.class);
        System.out.println(beansOfType);
    }

    /**
     * 给容器中注册组件
     * 1. 包扫描+组件标注注解(@Service/@Controller/@Repository/@Component)
     * 2. @Bean[导入第三方包]
     * 3. @Import
     *      >1 @Import id 默认是全类名
     *      >2 ImportSelect 返回需要的全类名数组
     *      >3 ImportBeanDefinitionRegistrar: 手动注册到容器中
     * 4. 使用Springt提供的FactoryBean(工厂)
     *      1.默认获取到的是工厂bean.调用的是getObject
     *      2.要获取工厂bean本身,需要加上&
     */

    /**
     * 6.@Import
     */
    @Test
    public void imports() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }

    /**
     * 7.使用@Import + ImportSelect结合
     */
    @Test
    public void selectimport() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportSelectConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }


    /**
     * @Import + ImportBeanDefinitionRegistrar
     */
    @Test
    public void importbeandefinition() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AndyConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }

    /**
     * 8.FactoryBean + @Bean
     */
    @Test
    public void factorybean() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppleConfig.class);
        Object apple = applicationContext.getBean("appleFactoryBean");
        System.out.println("apple = " + apple);
        Object appleFactoryBean = applicationContext.getBean("&appleFactoryBean");
        System.out.println("appleFactoryBean = " + appleFactoryBean);
    }

    /**
     * 9. Bean的生命周期 init-method destroy-method
     */
    @Test
    public void life(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfigLifeCycle.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        applicationContext.getBean("appleCycleBean");
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
        applicationContext.close();
    }

    /**
     * 10. Bean的生命周期 Init/Dis Bean
     */
    @Test
    public void life2(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfigLifeCycle2.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        applicationContext.getBean("appleCycleBean2");
        applicationContext.close();
    }

    /**
     * 11. 可以使用JSR250
     *  中的
     *  @PostConstruct
     * @PreDestory
     */

    /**
     *
     */
}
