package com.Microservice.Controller;

import com.Microservice.Entities.User;
import com.Microservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/User")
public class UserController {

    @Autowired
    private UserService userService;

    // http://localhost:8081/api/User

    @PostMapping
    public ResponseEntity<User> createData(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    // http://localhost:8081/api/User

    @GetMapping
    public ResponseEntity<List<User>> getAllData(){
        List<User> allUser = userService.getAllUser();
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }

    // http://localhost:8081/api/User/1

    @GetMapping("/{id}")
    public ResponseEntity<User> getDataById(@PathVariable("id") String userId){
        User user = userService.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // http://localhost:8081/api/User/1/updateData

    @PutMapping("/{id}/updateData")
    public ResponseEntity<User> updateDataById(@PathVariable("id") String uid, @RequestBody User user){
        User user1 = userService.updateUser(uid, user);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    // http://localhost:8081/api/User/1/deleteData

    @DeleteMapping("/{id}/deleteData")
    public ResponseEntity<String> deleteDataById(@PathVariable("id") String uid){
        userService.deleteUser(uid);
        return new ResponseEntity<>("Data Deleted Successfully!!", HttpStatus.OK);
    }
}
