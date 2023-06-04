package com.lcwd.Rating.Service.Service;

import com.lcwd.Rating.Service.Entity.Rating;

import java.util.List;

public interface RatingService {

    public Rating create(Rating rating);

    public List<Rating> getAll();

    public Rating get(String ratingId);

    public List<Rating> getByUserId(String userId);

    public List<Rating> getByHotelId(String hotelId);
}
