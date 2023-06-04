package com.lcwd.Hotel.Service.Service.ServiceImpl;

import com.lcwd.Hotel.Service.Entity.Hotel;
import com.lcwd.Hotel.Service.Exception.ResourceNotFoundException;
import com.lcwd.Hotel.Service.Repository.HotelRepository;
import com.lcwd.Hotel.Service.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository HotelRepo;


    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return HotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return HotelRepo.findAll();
    }

    @Override
    public Hotel get(String id) {
        return HotelRepo.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Hotel","ID",id));
    }
}
