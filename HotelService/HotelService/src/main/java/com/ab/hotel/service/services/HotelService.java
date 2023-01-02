package com.ab.hotel.service.services;

import com.ab.hotel.service.entities.Hotel;

import java.util.List;

public interface HotelService {

    //create hotel
    Hotel createHotel(Hotel hotel);

    //get All Hotel
    List<Hotel> getAllHotels();

    //get Single Hotel by Id
    Hotel getHotel(String id);
}
