package com.lcwd.Rating.Service.Service.ServiceImpl;

import com.lcwd.Rating.Service.Entity.Rating;
import com.lcwd.Rating.Service.Exception.ResourceNotFoundException;
import com.lcwd.Rating.Service.Repository.RatingRepository;
import com.lcwd.Rating.Service.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository RatingRepo;


    @Override
    public Rating create(Rating rating) {
        String ratings = UUID.randomUUID().toString();
        rating.setRatingId(ratings);
        return RatingRepo.save(rating);
    }

    @Override
    public List<Rating> getAll() {
        return RatingRepo.findAll();
    }

    @Override
    public Rating get(String ratingId) {
        return RatingRepo.findById(ratingId).orElseThrow(
                ()->new ResourceNotFoundException("Rating","ID",ratingId));
    }

    @Override
    public List<Rating> getByUserId(String userId) {
        return RatingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getByHotelId(String hotelId) {
        return RatingRepo.findByHotelId(hotelId);
    }
}
