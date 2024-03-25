package com.RestAPI.RestAPI.repositories;

import com.RestAPI.RestAPI.models.ProdutosModelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorio extends JpaRepository<ProdutosModelo, String> {
}
