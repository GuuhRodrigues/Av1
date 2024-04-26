package com.example.Av1.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "news")
public class NewsEntity {

    private String dados;

    public NewsEntity(String dados) {
        this.dados = dados;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }
}
