package com.aneel.crud.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aneel.crud.crud.model.Movies;
import com.aneel.crud.crud.repo.MoviesRepo;

@Service
public class MoviesService {
    
    @Autowired
    MoviesRepo mr;

    public ResponseEntity<List<Movies>> getMovies(){
        return new ResponseEntity<>(mr.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Optional<Movies>> getMovie(String imdbId){
        return new ResponseEntity<>(mr.findByImdbId(imdbId), HttpStatus.OK);
    }
    public ResponseEntity<String> addMovie(Movies movie){
        mr.save(movie);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
}
