package com.lcwd.Hotel.Service.Service;

import com.lcwd.Hotel.Service.Entity.Hotel;

import java.util.List;

public interface HotelService {

    public Hotel create(Hotel hotel);

    public List<Hotel> getAll();

    public Hotel get(String id);
}
