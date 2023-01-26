package com.example.demo.config;

import com.example.demo.filter.MyNewFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterConfig {
    @Bean
    public FilterRegistrationBean<MyNewFilter>registrationBean(){
         FilterRegistrationBean<MyNewFilter>myNewFilterFilterRegistrationBean=new FilterRegistrationBean<>();
         myNewFilterFilterRegistrationBean.setFilter(new MyNewFilter());
         myNewFilterFilterRegistrationBean.addUrlPatterns("/customers");
         return myNewFilterFilterRegistrationBean;
    }
}
