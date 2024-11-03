package com.samar.technology.LivesTracker.controller;

import com.samar.technology.LivesTracker.model.Blog;
import com.samar.technology.LivesTracker.model.User;
import com.samar.technology.LivesTracker.service.BlogService;
import com.samar.technology.LivesTracker.service.UserService;
import com.samar.technology.LivesTracker.utility.BlogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/apis/v1/blogs")
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<BlogDto> createBlog(
            @RequestParam("blog-heading") String blogHeading,
            @RequestParam("blog-content") String blogContent,
            @RequestParam("blog-image")MultipartFile image,
            @RequestHeader("username") String username) throws IOException {

        User userWithUsername = userService.findByUsername(username);
        if(username==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Blog savedBlog = blogService.postBlog(blogHeading,blogContent,image,userWithUsername);

        BlogDto responseToBeSent = new BlogDto(savedBlog.getId(),savedBlog.getBlogHeading(),savedBlog.getBlogContent(),savedBlog.getBlogImage().toString().substring(0,10)+"samar");
        if(userWithUsername!=null){
           userWithUsername.getUserBlogs().add(savedBlog);
           userService.createUser(userWithUsername);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(responseToBeSent);
    }


    @GetMapping
    public ResponseEntity<List<BlogDto>> getAllBlogs(){
        List<BlogDto> sendResponseBlog=new ArrayList<>();
        List<Blog> fetchedBlogs = blogService.getBlogs();

        fetchedBlogs.stream().forEach(e->{
            sendResponseBlog.add(new BlogDto(e.getId(),e.getBlogHeading(),e.getBlogContent(),e.getBlogImage().toString().substring(0,10)+"samar"));
        });
        return ResponseEntity.status(HttpStatus.FOUND).body(sendResponseBlog);
    }

    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog.getBlogImage() != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(blog.getBlogImage());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public String deleteBlogs(@PathVariable Long id){
        if(blogService.findById(id)!=null){
            blogService.deleteBLogById(id);
            return "blog deleted successfully with id : " +id;
        }

        return "blog can't be deleted, no blog found for the given id !";
    }



}
