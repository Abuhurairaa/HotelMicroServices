package com.ab.hotel.service.services.impl;

import com.ab.hotel.service.entities.Hotel;
import com.ab.hotel.service.repositories.HotelRepository;
import com.ab.hotel.service.services.HotelService;
import com.ab.hotel.service.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Hotel with the Given Id is not Found!!") );
    }
}
