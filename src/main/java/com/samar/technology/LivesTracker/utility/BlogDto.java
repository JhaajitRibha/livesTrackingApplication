package com.samar.technology.LivesTracker.utility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {
    private long blogId;
    private String blogHeading;
    private String blogContent;
    private String imageName;
}
