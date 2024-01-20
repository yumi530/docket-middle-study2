package com.example.dockerstudy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class BlogUpdateRequest {

    private String content;
    private String title;
}

