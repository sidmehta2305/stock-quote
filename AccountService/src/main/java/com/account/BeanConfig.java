package com.account;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

import com.account.service.CallNotificationService;

// config files got called first and commandline configurations are called later
@Configuration
public class BeanConfig {
    @Bean
    //@LoadBalanced
    public RestTemplate getRestTemplate(RestTemplateBuilder builder){ return new RestTemplate();}

    @Bean(name = "call")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public CallNotificationService getCallNotificationService(){
        return new CallNotificationService();
    }
    // use @Resource(name = "call") when auto-wiring
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

}
