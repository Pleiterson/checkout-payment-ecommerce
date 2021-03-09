package com.pleiterson.ecommerce.checkoutpaymentecommerce.service;

import com.pleiterson.ecommerce.checkoutapiecommerce.event.CheckoutCreatedEvent;
import com.pleiterson.ecommerce.checkoutpaymentecommerce.entity.PaymentEntity;

import java.util.Optional;

public class PaymentService {
    Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent);
}
