package com.samar.technology.LivesTracker.controller;

import com.samar.technology.LivesTracker.model.Friend;
import com.samar.technology.LivesTracker.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/v1")
public class FriendController {

    @Autowired
    FriendService friendService;
    @GetMapping("/friends")
    public List<Friend> findAll(){
        return friendService.getAllFriends();
    }

    @PostMapping("/friend")
    public ResponseEntity<Friend> makeFriend(@RequestBody Friend friend){
        return new ResponseEntity<>(friend, HttpStatusCode.valueOf(200));
    }
}
