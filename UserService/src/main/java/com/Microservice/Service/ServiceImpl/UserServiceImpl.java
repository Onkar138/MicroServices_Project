package com.Microservice.Service.ServiceImpl;

import com.Microservice.Entities.Hotel;
import com.Microservice.Entities.Rating;
import com.Microservice.Entities.User;
import com.Microservice.Exception.ResourceNotFoundException;
import com.Microservice.External.Service.HotelService;
import com.Microservice.Repository.UserRepository;
import com.Microservice.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public User saveUser(User user) {
        String randomUserId= UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {

        List<User> users = userRepo.findAll();
        return users;
    }

    @Override
    public User getUser(String userId) {
        User user = userRepo.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "Id", userId));

        // http://localhost:8083/Ratings/users/6c87b49f-2e4d-4c32-96e9-8ff1d377aa41
        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/Ratings/users/"+user.getUserId(), Rating[].class);
        logger.info("{}",ratingsOfUser);
        List<Rating> ratings=Arrays.stream(ratingsOfUser).collect(Collectors.toList());
        List<Rating> ratingList = ratings.stream().map(rating -> {
  //                    ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/Hotels/" + rating.getHotelId(), Hotel.class);
            Hotel hotel =hotelService.gethotel(rating.getHotelId());
  //            logger.info("response status code: {}", forEntity.getStatusCode());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());


        user.setRating(ratingList);
        return user;

    }

    @Override
    public User updateUser(String uid,User user) {
        User newuser = userRepo.findById(uid).orElseThrow(
                () -> new ResourceNotFoundException("User", "Id", uid));

          newuser.setName(user.getName());
          newuser.setEmail(user.getEmail());
          newuser.setAbout(user.getAbout());
          return userRepo.save(newuser);

    }

    @Override
    public void deleteUser(String uid) {
        userRepo.findById(uid).orElseThrow(
                () -> new ResourceNotFoundException("User", "Id", uid));
        userRepo.deleteById(uid);
    }
}
