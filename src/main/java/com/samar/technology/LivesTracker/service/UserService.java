package com.samar.technology.LivesTracker.service;


import com.samar.technology.LivesTracker.mapper.UserRowMapper;
import com.samar.technology.LivesTracker.model.Blog;
import com.samar.technology.LivesTracker.model.User;
import com.samar.technology.LivesTracker.repository.UserRepository;
import com.samar.technology.LivesTracker.utility.BlogDto;
import com.samar.technology.LivesTracker.utility.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Transactional
    public List<UserDto> getAllUsers() {
       List<User> users = userRepository.findAll();

       List<UserDto> convertedUsers=users.stream().map(user->{
           List<BlogDto> blogs = user.getUserBlogs().stream().map(
                   blog->{
                       return new BlogDto(
                               blog.getId(),blog.getBlogHeading(),blog.getBlogContent(),
                               blog.getBlogImage().toString().substring(0,10)+"samar"
                       );
                   }
           ).collect(Collectors.toList());

          return new UserDto(user.getId(),user.getUsername(),user.getEmail(),user.getFriends(),blogs);
       }).collect(Collectors.toList());

       return  convertedUsers;
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Transactional
    public UserDto getUserById(Long id) {
       User  user = userRepository.findById(id).get();
       List<BlogDto> convertedBlog = user.getUserBlogs().stream().map(blog->{
          return new BlogDto(blog.getId(),blog.getBlogHeading(),blog.getBlogContent(),blog.getBlogImage().toString().substring(0,10)+"samar");
       }).toList();

       return new UserDto(user.getId(),user.getUsername(),user.getEmail(),user.getFriends(),convertedBlog);
    }

    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow();
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
