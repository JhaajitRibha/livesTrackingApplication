package com.samar.technology.LivesTracker.repository;

import com.samar.technology.LivesTracker.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend,Long> {

}
