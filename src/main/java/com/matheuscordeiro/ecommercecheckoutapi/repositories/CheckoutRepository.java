package com.matheuscordeiro.ecommercecheckoutapi.repositories;

import com.matheuscordeiro.ecommercecheckoutapi.entities.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Long>{
}
