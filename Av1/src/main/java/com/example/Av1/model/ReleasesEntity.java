package com.example.Av1.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "releases")
public class ReleasesEntity {

    private String dados;

    public ReleasesEntity(String dados) {
        this.dados = dados;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }
}
