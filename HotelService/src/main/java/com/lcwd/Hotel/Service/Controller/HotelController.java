package com.lcwd.Hotel.Service.Controller;

import com.lcwd.Hotel.Service.Entity.Hotel;
import com.lcwd.Hotel.Service.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // http://localhost:8082/Hotels

    @PostMapping
    public ResponseEntity<Hotel> create(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.create(hotel);
        return new ResponseEntity<>(hotel1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAll(){
        List<Hotel> all = hotelService.getAll();
        return new ResponseEntity<List<Hotel>>(all, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> get(@PathVariable String id){
        Hotel hotel = hotelService.get(id);
        return new ResponseEntity<>(hotel, HttpStatus.CREATED);
    }
}
