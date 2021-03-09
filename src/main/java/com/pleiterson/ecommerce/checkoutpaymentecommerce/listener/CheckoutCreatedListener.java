package com.pleiterson.ecommerce.checkoutpaymentecommerce.listener;

import com.pleiterson.ecommerce.checkoutapiecommerce.event.CheckoutCreatedEvent;
import com.pleiterson.ecommerce.checkoutpaymentecommerce.entity.PaymentEntity;
import com.pleiterson.ecommerce.checkoutpaymentecommerce.event.PaymentCreatedEvent;
import com.pleiterson.ecommerce.checkoutpaymentecommerce.service.PaymentService;
import com.pleiterson.ecommerce.checkoutpaymentecommerce.streaming.CheckoutProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CheckoutCreatedListener {
    private final CheckoutProcessor checkoutProcessor;

    private final PaymentService paymentService;

    @StreamListener(CheckoutProcessor.INPUT)
    public void handler(CheckoutCreatedEvent checkoutCreatedEvent) {
        log.info("checkoutCreatedEvent={}", checkoutCreatedEvent);
        final PaymentEntity paymentEntity = paymentService.create(checkoutCreatedEvent).orElseThrow();
        final PaymentCreatedEvent paymentCreatedEvent = PaymentCreatedEvent.newBuilder()
                .setCheckoutCode(paymentEntity.getCheckoutCode())
                .setPaymentCode(paymentEntity.getCode())
                .build();
        checkoutProcessor.output().send(MessageBuilder.withPayload(paymentCreatedEvent).build());
    }
}
