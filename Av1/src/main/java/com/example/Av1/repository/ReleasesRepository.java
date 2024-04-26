package com.example.Av1.repository;

import com.example.Av1.model.ReleasesEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleasesRepository extends MongoRepository<ReleasesEntity, String> {
}
