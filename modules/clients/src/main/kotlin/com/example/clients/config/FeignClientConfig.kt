package com.example.clients.config

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@EnableFeignClients(basePackages = ["com.example.clients"])
@Configuration
class FeignClientConfig