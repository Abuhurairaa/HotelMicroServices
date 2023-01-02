package com.ab.user.service.impl;

import com.ab.user.service.entities.Hotel;
import com.ab.user.service.entities.Rating;
import com.ab.user.service.entities.User;
import com.ab.user.service.exceptions.ResourceNotFundException;
import com.ab.user.service.external.services.HotelService;
import com.ab.user.service.repositories.UserRepository;
import com.ab.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired private UserRepository userRepository;
    @Autowired private RestTemplate restTemplate;
    @Autowired private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        //generate unique userId
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    //get all Users
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //get single Users
    @Override
    public User getUser(String userId) {
        //get user from DB
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFundException("User With Given Id is Not Fund On Server!! :"+userId));
        //fetch user Rating from RatingService
        //http://localhost:8083/ratings/users/11e6170d-89a2-44fe-b290-1f2461c58cc4
        Rating[] userRatings= restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        logger.info("{} ",userRatings);

        List<Rating> ratings = Arrays.asList(userRatings);

        List<Rating> ratingList = ratings.stream().map(rating -> {
            //api call for HotelService to get Hotels
            //http://localhost:8082/hotels/02eca849-861a-43c7-9ec3-1986ed17de55

//            ResponseEntity<Hotel> response = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+ rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
//            logger.info("Response Status Code {} ",response.getStatusCode());
            //set Hotel Rating
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return user;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User deleteUser(String userId) {
        return null;
    }
}
