package com.example.dockerstudy.cotroller;

import com.example.dockerstudy.domain.Blog;
import com.example.dockerstudy.dto.BlogCreateRequest;
import com.example.dockerstudy.dto.BlogUpdateRequest;
import com.example.dockerstudy.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/blog")
public class BlogController {

    private final BlogService blogService;

    @GetMapping
    public ResponseEntity<?> list () {
        return ResponseEntity.ok(blogService.getList());
    }

    @PostMapping
    public ResponseEntity<?> createBlog(
            @RequestBody BlogCreateRequest request
    ) {
        blogService.create(request);
        return ResponseEntity.ok("created");
    }

//    @PutMapping
//    public ResponseEntity<BlogUpdateRequest> update(BlogUpdateRequest request) {
//        return ResponseEntity.ok(blogService.update(request);
//    }
//
//    @DeleteMapping
//    public ResponseEntity delete(Long id) {
//        blogService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
@PutMapping("/{id}")
public ResponseEntity<?> updateBlog(
        @PathVariable("id") Long id,
        @RequestBody BlogUpdateRequest request
) {
    blogService.update(id, request);
    return ResponseEntity.ok("updated");
}

    // blog 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBlog(
            @PathVariable("id") Long id
    ) {
        blogService.delete(id);
        return ResponseEntity.ok("deleted");
    }
}
