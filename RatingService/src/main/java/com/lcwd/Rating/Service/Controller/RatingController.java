package com.lcwd.Rating.Service.Controller;

import com.lcwd.Rating.Service.Entity.Rating;
import com.lcwd.Rating.Service.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Ratings")
public class RatingController {

    @Autowired
    private RatingService RatingService;

    // http://localhost:8083/Ratings

    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        Rating rating1 = RatingService.create(rating);
        return new ResponseEntity<>(rating1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllData(){
        List<Rating> ratingList = RatingService.getAll();
        return new ResponseEntity<>(ratingList, HttpStatus.CREATED);
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getAllData(@PathVariable String ratingId){
        Rating rating = RatingService.get(ratingId);
        return new ResponseEntity<>(rating, HttpStatus.CREATED);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getDataByUserId(@PathVariable String userId){
        List<Rating> byUserId = RatingService.getByUserId(userId);
        return new ResponseEntity<>(byUserId, HttpStatus.CREATED);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getDataByHotelId(@PathVariable String hotelId){
        List<Rating> byHotelId = RatingService.getByHotelId(hotelId);
        return new ResponseEntity<>(byHotelId, HttpStatus.CREATED);
    }
}
