package com.samar.technology.LivesTracker.utility;

import com.samar.technology.LivesTracker.model.Friend;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long userId;
    private String username;
    private String email;
    private Set<Friend> friends;
    private List<BlogDto> blogs;

}
