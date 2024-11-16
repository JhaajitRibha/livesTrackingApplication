package com.samar.technology.LivesTracker;

public class Post {
    private Long id;
    private Long userId;
    private String title;
    private String body;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
