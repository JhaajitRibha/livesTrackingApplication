package com.samar.technology.LivesTracker.repository;


import com.samar.technology.LivesTracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("select u from user u where u.username=:username")
//    public User findByUsername(@Param("username") String username);

    public User findByUsername(String username);
}
