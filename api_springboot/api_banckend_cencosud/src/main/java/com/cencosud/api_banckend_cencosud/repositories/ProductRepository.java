package com.cencosud.api_banckend_cencosud.repositories;

import com.cencosud.api_banckend_cencosud.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {

}
