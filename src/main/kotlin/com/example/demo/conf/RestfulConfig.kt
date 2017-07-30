package com.example.demo.conf

import com.wrench.utils.restfulapi.RestTemplateWrapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class RestfulConfig {

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }

    @Bean
    fun restWrapper(): RestTemplateWrapper {
        return RestTemplateWrapper(restTemplate())
    }
}