package com.samar.technology.LivesTracker.utility;

import com.samar.technology.LivesTracker.model.Friend;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDto {
    private long userId;
    private String username;
    private String email;
    @XmlElementWrapper(name="friends")
    @XmlElement(name="friend")
    private Set<Friend> friends;
    @XmlElementWrapper(name="blogs")
    @XmlElement(name="blog")
    private List<BlogDto> blogs;

}
