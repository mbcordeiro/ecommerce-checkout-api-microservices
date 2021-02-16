package com.matheuscordeiro.ecommercecheckoutapi.servicies;

import com.matheuscordeiro.ecommercecheckoutapi.entities.Checkout;
import com.matheuscordeiro.ecommercecheckoutapi.enums.Status;
import com.matheuscordeiro.ecommercecheckoutapi.http.CheckoutRequest;
import com.matheuscordeiro.ecommercecheckoutapi.repositories.CheckoutRepository;
import com.matheuscordeiro.ecommercecheckoutapi.servicies.interfaces.CheckoutService;
import com.matheuscordeiro.ecommercecheckoutapi.streaming.CheckoutCreatedSource;
import com.matheuscordeiro.ecommercecheckoutapi.event.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    @Autowired
    CheckoutRepository checkoutRepository;

    @Autowired
    CheckoutCreatedSource checkoutCreatedSource;

    @Override
    public Optional<Checkout> create(CheckoutRequest checkoutRequest) {
        final Checkout checkout = Checkout.builder().code(UUID.randomUUID().toString()).status(Status.CREATED).build();
        final Checkout entity = checkoutRepository.save(checkout);
        final CheckoutCreatedEvent checkoutCreatedEvent = CheckoutCreatedEvent.newBuilder()
                .setCheckoutCode(entity.getCode())
                .setStatus(entity.getStatus().name())
                .build();
        checkoutCreatedSource.output().send(MessageBuilder.withPayload(checkoutCreatedEvent).build());
        return Optional.of(entity);
    }

    @Override
    public Optional<Checkout> updateStatus(String checkoutCode, Status status) {
        return Optional.empty();
    }
}
