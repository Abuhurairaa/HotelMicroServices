package com.ab.rating.service.repository;

import com.ab.rating.service.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,String> {
    //customs method
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
