package com.samar.technology.LivesTracker.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Basic(fetch = FetchType.LAZY)
    private byte[] blogImage;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonBackReference
    private User user;

}
