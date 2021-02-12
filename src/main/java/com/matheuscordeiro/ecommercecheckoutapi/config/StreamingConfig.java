package com.matheuscordeiro.ecommercecheckoutapi.config;

import com.matheuscordeiro.ecommercecheckoutapi.streaming.CheckoutCreatedSource;
import com.matheuscordeiro.ecommercecheckoutapi.streaming.PaymentPaidSink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(value = {
        CheckoutCreatedSource.class,
//        PaymentPaidSink.class
})
public class StreamingConfig {
}