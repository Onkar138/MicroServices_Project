package com.lcwd.Hotel.Service.Repository;

import com.lcwd.Hotel.Service.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
