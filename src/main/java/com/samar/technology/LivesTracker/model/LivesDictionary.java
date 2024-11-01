package com.samar.technology.LivesTracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lives-dictionary")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivesDictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="lives-id")
    private Long Id;

    @Column(name="word",nullable = false)
    private String word;


    @Column(name="word-meaning",columnDefinition = "TEXT",nullable = false)
    private String wordMeaning;

    @Column(name="author",nullable = false)
    private String author;
}
