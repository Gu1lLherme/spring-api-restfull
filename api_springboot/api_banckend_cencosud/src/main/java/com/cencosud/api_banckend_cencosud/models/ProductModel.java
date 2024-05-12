package com.cencosud.api_banckend_cencosud.models;


import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUCTS")
// Definição da Classe para criar uma tabela no DB com atrbutos
public class ProductModel implements Serializable {
    private static final long seriaVersionUID= 1L;

    // ATRIBUTOS

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID idApi;
    private String nome;
    private BigDecimal version;
    private String urlApi;
    private String endpoint;

    // METODOS

    public UUID getIdApi() {
        return idApi;
    }

    public void setIdApi(UUID idApi) {
        this.idApi = idApi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public String getUrlApi() {
        return urlApi;
    }

    public void setUrlApi(String urlApi) {
        this.urlApi = urlApi;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
