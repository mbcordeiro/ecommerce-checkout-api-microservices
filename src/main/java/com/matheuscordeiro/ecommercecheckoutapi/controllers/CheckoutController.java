package com.matheuscordeiro.ecommercecheckoutapi.controllers;

import com.matheuscordeiro.ecommercecheckoutapi.entities.Checkout;
import com.matheuscordeiro.ecommercecheckoutapi.http.CheckoutRequest;
import com.matheuscordeiro.ecommercecheckoutapi.http.CheckoutResponse;
import com.matheuscordeiro.ecommercecheckoutapi.servicies.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/checkout")
@RequiredArgsConstructor
public class CheckoutController {
    @Autowired
    CheckoutService checkoutService;

    @PostMapping
    public ResponseEntity<CheckoutResponse> create(CheckoutRequest checkoutRequest) {
        final Checkout checkout = checkoutService.create(checkoutRequest).orElseThrow();
        final CheckoutResponse checkoutResponse = CheckoutResponse.builder().code(checkout.getCode()).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(checkoutResponse);
    }
}
