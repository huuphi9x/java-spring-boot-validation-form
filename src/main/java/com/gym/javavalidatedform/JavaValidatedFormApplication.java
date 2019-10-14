package com.gym.javavalidatedform;

import com.gym.javavalidatedform.service.UserService;
import com.gym.javavalidatedform.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class JavaValidatedFormApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaValidatedFormApplication.class, args);
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("ValidationMessages");
        return messageSource;
    }

    @Bean
    public UserService userService()     {
        return new UserServiceImpl();
    }
}

