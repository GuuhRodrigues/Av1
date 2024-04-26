package com.example.Av1.service;

import com.example.Av1.model.NewsEntity;
import com.example.Av1.model.ReleasesEntity;
import com.example.Av1.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public String obterTodos() {
        String dadosNoticiasReleases = "";
        String apiUrl = "https://servicodados.ibge.gov.br/api/v3/noticias";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dadosNoticiasReleases = responseEntity.getBody();
        } else {
            dadosNoticiasReleases = "Falha ao obter dados de noticias e releases. Código de status: " + responseEntity.getStatusCode();
        }
        return dadosNoticiasReleases;
    }

    public String obterNoticias() {
        String dadosNoticias = "";
        String apiUrl = "https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=noticia";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dadosNoticias = responseEntity.getBody();
        } else {
            dadosNoticias = "Falha ao obter dados de noticias. Código de status: " + responseEntity.getStatusCode();
        }
        inserirDadosNoticias(dadosNoticias);
        return dadosNoticias;
    }

    public String obterReleases() {
        String dadosReleases = "";
        String apiUrl = "https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=release";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dadosReleases = responseEntity.getBody();
        } else {
            dadosReleases = "Falha ao obter dados de releases. Código de status: " + responseEntity.getStatusCode();
        }
        inserirDadosReleases(dadosReleases);
        return dadosReleases;
    }

    public void inserirDadosNoticias(String dadosNoticias) {
        NewsEntity newsEntity = new NewsEntity(dadosNoticias);
        newsRepository.save(newsEntity);
    }

    public void inserirDadosReleases(String dadosReleases) {
        ReleasesEntity releasesEntity = new ReleasesEntity(dadosReleases);
        newsRepository.save(releasesEntity);
    }

}
