package com.ab.user.service;

import com.ab.user.service.entities.Rating;
import com.ab.user.service.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired private RatingService ratingService;

//	@Test
//	void createRating(){
//		Rating rating = Rating.builder().rating(10).userId("").hotelId("")
//				.feedback("This is created using feign client").build();
//		ResponseEntity<Rating> savedRating = ratingService.createRating(rating);
//
//		System.out.println("New rating Created");
//	}

}
