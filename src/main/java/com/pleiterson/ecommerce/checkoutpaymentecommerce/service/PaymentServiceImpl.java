package com.pleiterson.ecommerce.checkoutpaymentecommerce.service;

import com.pleiterson.ecommerce.checkoutapiecommerce.event.CheckoutCreatedEvent;
import com.pleiterson.ecommerce.checkoutpaymentecommerce.entity.PaymentEntity;
import com.pleiterson.ecommerce.checkoutpaymentecommerce.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent) {
        final PaymentEntity paymentEntity = PaymentEntity.builder()
                .checkoutCode(checkoutCreatedEvent.getCheckoutCode())
                .code(UUID.randomUUID().toString())
                .build();
        paymentRepository.save(paymentEntity);
        return Optional.of(paymentEntity);
    }
}
