package com.ab.rating.service.services;

import com.ab.rating.service.entities.Rating;
import com.ab.rating.service.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface RatingService {

    //create
    Rating create(Rating rating);

    //get all Rating
    List<Rating> getAllRating();

    //Get all rating by UserId
    List<Rating> getRatingByUserId(String userId);

    //Get all rating bt Hotel
    List<Rating> getRatingByHotelId(String hotelId);
}
