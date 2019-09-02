package cn.andy.life.componentscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @ComponentScan value : 指定包扫描
 * excludeFilters = Filters[]: 排除
 * includeFilters =  Filters[] ; 只包含
 * <p>
 * FilterType.ANNOTATION: 按照注解
 * FilterType.ASSIGNABLE_TYPE: 按照给定的类型
 * FilterType.CUSTOM: 定制过滤规则
 * FilterType.ASPECTJ: 使用ASPECTJ表达式
 * FilterType.REGEX: 使用正则表达式
 */
/*@ComponentScan(value = "cn.andy", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
})*/
@Configuration
@ComponentScans(
        value = @ComponentScan(value = "cn.andy", includeFilters = {
                // @Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
                // @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class})
                @Filter(type = FilterType.CUSTOM, classes = {MyFilter.class})
        }, useDefaultFilters = false)
)
public class ComponentConfig {
}
