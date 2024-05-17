package com.cencosud.api_banckend_cencosud.controllers;


import com.cencosud.api_banckend_cencosud.dtos.ProductRecordDto;
import com.cencosud.api_banckend_cencosud.models.ProductModel;
import com.cencosud.api_banckend_cencosud.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// CRUD - CREATE, READ, UPDATE, DELETE

@RestController
public class ProductController {

    // Ponto de Injeção da interface "ProductRepository"
    @Autowired
    ProductRepository productRepository;

    // POST - CREATE

    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
        var productModel = new ProductModel();
        // Transforma os atributos Json em java
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    // GET ALL - READ

    @GetMapping("/all/products")
    public ResponseEntity<List<ProductModel>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }

    // GET ONE - READ

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id") UUID id){
        Optional <ProductModel> productO = productRepository.findById(id);
        if(productO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("API not found");
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(productO.get());
        }
    }

    // PUT - UPDATE

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid ProductRecordDto productRecordDto) {

        Optional<ProductModel> productO = productRepository.findById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("API not fund");
        }

        var productUpdate = productO.get();
        BeanUtils.copyProperties(productRecordDto, productUpdate);
        return  ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productUpdate));

    }

    // DEL - DELETE

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") UUID id){
        Optional<ProductModel> productO = productRepository.findById(id);
        if (productO.isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("API not found");
        }

        productRepository.delete(productO.get());
        return ResponseEntity.status(HttpStatus.OK).body("API delete successfully");
    }


}
