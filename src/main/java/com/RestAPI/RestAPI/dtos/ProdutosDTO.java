package com.RestAPI.RestAPI.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutosDTO(@NotBlank String nome, @NotNull BigDecimal valor) {
}
