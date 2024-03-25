package com.RestAPI.RestAPI.controllers;

import com.RestAPI.RestAPI.dtos.ProdutosDTO;
import com.RestAPI.RestAPI.models.ProdutosModelo;
import com.RestAPI.RestAPI.repositories.ProdutoRepositorio;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProdutosController {

    @Autowired
    ProdutoRepositorio produtoRepositorio;

    @GetMapping("/online")
    public String testarAPI(){
        return "API FUNCIONANDO NORMALMENTE";
    }

    @PostMapping("/produtos")
    public ResponseEntity<ProdutosModelo> adicionarProduto(@RequestBody @Valid ProdutosDTO produtoDTO){
        var modeloProduto = new ProdutosModelo();
        BeanUtils.copyProperties(produtoDTO, modeloProduto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepositorio.save(modeloProduto));

    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutosModelo>> listarTodosOsProdutos(){
        List<ProdutosModelo> listaProdutos = produtoRepositorio.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listaProdutos);
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Object> listarProdutosPorId(@PathVariable(value="id") String id){
        Optional<ProdutosModelo> listaProdutos = produtoRepositorio.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(listaProdutos);
    }

}
