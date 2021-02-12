package com.matheuscordeiro.ecommercecheckoutapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Checkout{
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String code;
}