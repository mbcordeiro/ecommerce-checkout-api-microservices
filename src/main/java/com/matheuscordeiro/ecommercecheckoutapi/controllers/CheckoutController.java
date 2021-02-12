package com.matheuscordeiro.ecommercecheckoutapi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/checkout")
@RequiredArgsConstructor
public class CheckoutController {

    @PostMapping
    public ResponseEntity<Void> create() {
        return ResponseEntity.ok().build();
    }
}
