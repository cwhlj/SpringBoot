# SpringBoot
#### @SpringBootApplication = (默认属性)@Configuration + @EnableAutoConfiguration + @ComponentScan
```
@SpringBootApplication 
public class ApplicationMain { 
    public static void main(String[] args) { 
        SpringApplication.run(Application.class, args); 
    } 
}
```
#### 1、@Configuration：提到@Configuration就要提到他的搭档@Bean。使用这两个注解就可以创建一个简单的spring配置类，可以用来替代相应的xml配置文件。
```
<beans> 
    <bean id = "car" class="com.test.Car"> 
        <property name="wheel" ref = "wheel"></property> 
    </bean> 
    <bean id = "wheel" class="com.test.Wheel"></bean> 
</beans> 
```
相当于
```
@Configuration 
public class Conf { 
    @Bean 
    public Car car() { 
        Car car = new Car(); 
        car.setWheel(wheel()); 
        return car; 
    } 
    @Bean  
    public Wheel wheel() { 
        return new Wheel(); 
    } 
}
```

#### @Configuration的注解类标识这个类可以使用Spring IoC容器作为bean定义的来源。@Bean注解告诉Spring，一个带有@Bean的注解方法将返回一个对象，该对象应该被注册为在Spring应用程序上下文中的bean。
#### 2、@EnableAutoConfiguration：能够自动配置spring的上下文，试图猜测和配置你想要的bean类，通常会自动根据你的类路径和你的bean定义自动配置。
#### 3、@ComponentScan：会自动扫描指定包下的全部标有@Component的类，并注册成bean，当然包括@Component下的子注解@Service,@Repository,@Controller。
#### 4、@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
 该注解的作用是，排除自动注入数据源的配置（取消数据库配置），一般使用在客户端（消费者）服务中


SpringBoot[面试题](https://yq.aliyun.com/articles/652497?spm=a2c4e.11153940.0.0.28a37145yAxDiw)