package com.aneel.crud.crud.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.aneel.crud.crud.model.Reviews;

public interface ReviewRepo extends MongoRepository<Reviews,ObjectId>{
    
}
