package com.example.dockerstudy.service;

import com.example.dockerstudy.domain.Blog;
import com.example.dockerstudy.domain.BlogRepository;
import com.example.dockerstudy.dto.BlogCreateRequest;
import com.example.dockerstudy.dto.BlogUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    public List<Blog> getList() {
        return blogRepository.findAll();
    }

    public void create(BlogCreateRequest request) {
        blogRepository.save(Blog.of(request));
    }

    public void update(Long blogId, BlogUpdateRequest request) {
        Blog blog = blogRepository.findById(blogId).orElseThrow(RuntimeException::new);
        blog.update(request);
    }

    public void delete(Long blogId) {
        blogRepository.deleteById(blogId);
    }
}
