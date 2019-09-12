package com.cheng.springboot;

import com.cwhlj.common.web.filter.access.AccessFilterFactory;
import com.cwhlj.common.web.interceptor.AuthInterceptor;
import com.cwhlj.common.web.interceptor.GlobalInterceptor;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.PostConstruct;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 * @author chengwei
 * @date 2019-08-29 14:53
 */
@Configuration
public class SpringBootApplicationConfig extends WebMvcConfigurationSupport {
    private AccessFilterFactory accessFilterFactory;

    @PostConstruct
    public void init() {
        accessFilterFactory = new AccessFilterFactory();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        registry.addInterceptor(new GlobalInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new AuthInterceptor(accessFilterFactory)).addPathPatterns("/**").excludePathPatterns(
                "/login/**");

        super.addInterceptors(registry);
    }

    @Bean
    public Validator validator() {
        return Validation.byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();
    }
}
