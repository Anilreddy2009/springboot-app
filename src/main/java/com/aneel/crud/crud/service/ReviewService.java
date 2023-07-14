package com.aneel.crud.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.aneel.crud.crud.model.Movies;
import com.aneel.crud.crud.model.Reviews;
import com.aneel.crud.crud.repo.ReviewRepo;

@Service
public class ReviewService {
    
    @Autowired
    ReviewRepo rr;

    @Autowired
    MongoTemplate mt;

    public String addReview(String body, String imdbId){
        Reviews r= rr.insert(new Reviews(body)); 

        try{
            mt.update(Movies.class)
                    .matching(Criteria.where("imdbId").is(imdbId))
                    .apply(new Update().push("reviewIds").value(r))
                    .first();
            return "Success";
        }catch(Exception e){
            return "failed";
        }
    }
}
