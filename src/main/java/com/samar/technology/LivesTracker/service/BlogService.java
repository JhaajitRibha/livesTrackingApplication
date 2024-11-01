package com.samar.technology.LivesTracker.service;

import com.samar.technology.LivesTracker.model.Blog;
import com.samar.technology.LivesTracker.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;
    public Blog postBlog(String blogHeading, String blogContent, MultipartFile blogImage) throws IOException {
        Blog blog = new Blog();
        blog.setBlogHeading(blogHeading);
        blog.setBlogContent(blogContent);
        blog.setBlogImage(blogImage.getBytes());
        return blogRepository.save(blog);
    }

    public List<Blog> getBlogs(){
        return blogRepository.findAll();

    }

    public Blog findById(Long id){
        return blogRepository.findById(id).get();
    }

    public void deleteBLogById(Long id){
        blogRepository.deleteById(id);
    }
}
