package com.samar.technology.LivesTracker.service;

import com.samar.technology.LivesTracker.model.Friend;
import com.samar.technology.LivesTracker.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    @Autowired
    private FriendRepository friendRepository;
    public List<Friend> getAllFriends() {
        return friendRepository.findAll();
    }

    public Friend makeFriend(Friend friend) {
        return friendRepository.save(friend);
    }
}
