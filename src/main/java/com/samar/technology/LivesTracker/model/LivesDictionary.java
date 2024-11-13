package com.samar.technology.LivesTracker.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lives-dictionary")
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name="lives-dictionary")
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

    @XmlAttribute(name="lives-id")
    public Long getId(){
        return Id;
    }

    @XmlElement(name="word")
    public String getWord(){
        return word;
    }

    @XmlElement(name="word-meaning")
    public String getWordMeaning()
    {
        return wordMeaning;
    }

    @XmlElement(name="author")
    public String getAuthor(){
        return author;
    }
}
