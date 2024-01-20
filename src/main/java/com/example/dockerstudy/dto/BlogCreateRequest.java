package com.example.dockerstudy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class BlogCreateRequest {

    private String content;
    private String title;
}
