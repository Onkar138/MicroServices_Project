package com.Microservice.External.Service;

import com.Microservice.Entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/Hotels/{hotelId}")
    public Hotel gethotel(@PathVariable("hotelId") String hotelId);


}
