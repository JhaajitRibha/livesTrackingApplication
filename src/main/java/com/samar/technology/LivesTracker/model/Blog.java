package com.samar.technology.LivesTracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="blogs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @Column(name="blog-id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="blog-heading",nullable = false)
    private String blogHeading;
    @Column(name="blog-content",nullable = false,columnDefinition = "TEXT")
    private String blogContent;

    @Lob
    @Column(name="blog-image")
    private byte[] blogImage;

}
