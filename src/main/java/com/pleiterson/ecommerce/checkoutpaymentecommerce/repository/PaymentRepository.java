package com.pleiterson.ecommerce.checkoutpaymentecommerce.repository;

import com.pleiterson.ecommerce.checkoutpaymentecommerce.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public class PaymentRepository extends JpaRepository<PaymentEntity, Long> {
    
}
