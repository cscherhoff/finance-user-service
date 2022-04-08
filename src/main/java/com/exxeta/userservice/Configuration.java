package com.exxeta.userservice;

import com.exxeta.userservice.exceptions.MyErrorDecoder;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public MyErrorDecoder myErrorDecoder() {
        return new MyErrorDecoder();
    }
}
