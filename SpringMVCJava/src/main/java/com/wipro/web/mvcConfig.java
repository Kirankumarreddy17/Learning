package com.wipro.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"controller", "web", "model"})
public class mvcConfig implements WebMvcConfigurer {

@Bean
public InternalResourceViewResolver resolver() {
    InternalResourceViewResolver vr = new InternalResourceViewResolver();
    vr.setPrefix("/WEB-INF/views/");
    vr.setSuffix(".jsp");
    return vr;
}


}

