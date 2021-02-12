package com.matheuscordeiro.ecommercecheckoutapi.servicies;

import com.matheuscordeiro.ecommercecheckoutapi.entities.Checkout;
import com.matheuscordeiro.ecommercecheckoutapi.enums.Status;
import com.matheuscordeiro.ecommercecheckoutapi.http.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {
    Optional<Checkout> create(CheckoutRequest checkoutRequest);

    Optional<Checkout> updateStatus(String checkoutCode, Status status);
}
