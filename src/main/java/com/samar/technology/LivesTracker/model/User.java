            package com.samar.technology.LivesTracker.model;


            import com.fasterxml.jackson.annotation.JsonIgnore;
            import com.fasterxml.jackson.annotation.JsonManagedReference;
            import com.samar.technology.LivesTracker.utility.BlogDto;
            import jakarta.persistence.*;
            import jakarta.xml.bind.annotation.XmlElement;
            import jakarta.xml.bind.annotation.XmlElementWrapper;

            import java.util.ArrayList;
            import java.util.HashSet;
            import java.util.List;
            import java.util.Set;


            @Entity
            @Table(name = "users")
            public class User {

                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                private Long id;

                @Column(nullable = false)
                private String username;

                @Column(nullable = false)
                private String email;

                @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
                @JsonManagedReference
                private Set<Friend> friends = new HashSet<>();

                @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
                @JsonManagedReference
                private List<Blog> userBlogs = new ArrayList<>();


                public User() {}

                public User(String username, String email) {
                    this.username = username;
                    this.email = email;
                }

                public List<Blog> getUserBlogs() {
                    return userBlogs;
                }

                public void setUserBlogs(List<Blog> userBlogs) {
                    this.userBlogs = userBlogs;
                }

                public Set<Friend> getFriends() {
                    return friends;
                }

                public void setFriends(Set<Friend> friends) {
                    this.friends = friends;
                }

                // Getters and Setters
                public Long getId() {
                    return id;
                }

                public void setId(Long id) {
                    this.id = id;
                }

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }

                public String getEmail() {
                    return email;
                }

                public void setEmail(String email) {
                    this.email = email;
                }

                @Override
                public String toString() {
                    return "User{" +
                            "id=" + id +
                            ", username='" + username + '\'' +
                            ", email='" + email + '\'' +
                            ", friends=" + friends +
                            ", userBlogs=" + userBlogs +
                            '}';
                }
            }
