package com.cencosud.api_banckend_cencosud.controllers;


import com.cencosud.api_banckend_cencosud.dtos.ProductRecordDto;
import com.cencosud.api_banckend_cencosud.models.ProductModel;
import com.cencosud.api_banckend_cencosud.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Realização do CRUD

@RestController
public class ProductController {

    // Ponto de Injeção da interface "ProductRepository"
    @Autowired
    ProductRepository productRepository;

    // CRUD - POST
    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
        var productModel = new ProductModel();
        // Transforma os atributos Json em java
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    // GET ALL
    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }


}
