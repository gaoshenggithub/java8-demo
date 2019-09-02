package cn.andy.life.beanfactory;

public class AppleFactoryBean implements org.springframework.beans.factory.FactoryBean<Apple> {


    @Override
    public Apple getObject() throws Exception {
        return new Apple();
    }

    @Override
    public Class<?> getObjectType() {
        return Apple.class;
    }

    /**
     * 返回是否是单利
     * true 是
     * false 不是
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
