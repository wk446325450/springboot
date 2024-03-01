package com.wk.boot;

import com.wk.boot.bean.Person;
import com.wk.boot.config.MyConFig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author： 魏凯
 * @version: 1.0
 * @desc： TODO
 */
/*主程序类/主配置类
* @SpringBootApplication：这个注解的作用，告诉其这是一个springboot应用
* */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        //1.返回ioc容器
        ConfigurableApplicationContext run = SpringApplication.run(Main.class, args);
        //2.查看容器中的组件
        String[] beans = run.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }
        //3.在容器中获取组件,且该组件是唯一的，不是每次都创建一个新对象
        Person person01 = run.getBean("person01", Person.class);
        System.out.println(person01);
        Person person03 = run.getBean("person01", Person.class);
        System.out.println(person01==person03);

//        proxyBeanMethods:代理bean的方法   ,这个是@Configuration注解中默认为true的属性
        MyConFig conFig = run.getBean(MyConFig.class);//配置类也是一个组件，被存放在ioc中，且可调用其他的组件
        //配置类对象调用出来的对象也是单实例的，因为proxyBeanMethods属性的缘故,
        //@Configuration(proxyBeanMethods = true就是代理对象调用方法，springboot总会调查其是否在容器中存在，保持其单实例

    }

}
