package com.starter.userincomestarter;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(IncomeProperties.class)
public class IncomeAutoConfiguration {

    @Bean
    public IncomeClient incomeClient() {
        return new IncomeClient();
    }
}