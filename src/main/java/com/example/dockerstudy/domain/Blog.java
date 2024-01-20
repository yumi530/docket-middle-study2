package com.example.dockerstudy.domain;

import com.example.dockerstudy.dto.BlogCreateRequest;
import com.example.dockerstudy.dto.BlogUpdateRequest;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "blog")
@ToString
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private String title;

    @Builder
    public Blog(Long id, String title, String content, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    public static Blog of(BlogCreateRequest request) {
        return Blog.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public void update(BlogUpdateRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();
    }
}
