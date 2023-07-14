package com.aneel.crud.crud.repo;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.aneel.crud.crud.model.Movies;


public interface MoviesRepo extends MongoRepository<Movies,ObjectId> {
    
    Optional<Movies> findByImdbId(String imdbId);
}
