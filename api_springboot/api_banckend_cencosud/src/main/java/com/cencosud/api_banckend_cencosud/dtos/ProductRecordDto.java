package com.cencosud.api_banckend_cencosud.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

// DTO - Data Transference Object
// Transforma os atributos Json em java
// Dados que o cliente fornece

//
public record ProductRecordDto(@NotBlank String nome, @NotNull BigDecimal version, @NotBlank String urlApi, @NotBlank String endpoint) {
}
