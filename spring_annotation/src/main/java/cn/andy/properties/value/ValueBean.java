package cn.andy.properties.value;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Data
//@Configuration
public class ValueBean {
    //使用@Value赋值:
    //基本数值
    //SpLE,#{}
    //可以写${}取出配置文件的值
    @Value("22")
    private String username;
    @Value("#{22-22}")
    private String password;
    @Value("${valueBean.gender}")
    private String gender;
}
