package com.matheuscordeiro.ecommercecheckoutapi.servicies;

import com.matheuscordeiro.ecommercecheckoutapi.entities.Checkout;
import com.matheuscordeiro.ecommercecheckoutapi.enums.Status;
import com.matheuscordeiro.ecommercecheckoutapi.http.CheckoutRequest;
import com.matheuscordeiro.ecommercecheckoutapi.repositories.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    @Autowired
    CheckoutRepository checkoutRepository;

    @Override
    public Optional<Checkout> create(CheckoutRequest checkoutRequest) {
        final Checkout checkout = Checkout.builder().code(UUID.randomUUID().toString()).status(Status.CREATED).build();
        return Optional.of(checkoutRepository.save(checkout));
    }

    @Override
    public Optional<Checkout> updateStatus(String checkoutCode, Status status) {
        return Optional.empty();
    }
}
