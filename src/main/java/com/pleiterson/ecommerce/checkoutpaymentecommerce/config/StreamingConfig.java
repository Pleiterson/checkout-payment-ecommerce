package com.pleiterson.ecommerce.checkoutpaymentecommerce.config;

import com.pleiterson.ecommerce.checkoutpaymentecommerce.streaming.CheckoutProcessor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(CheckoutProcessor.class)
public class StreamingConfig {
    
}
