package com.example.dockerstudy.init;

import com.example.dockerstudy.dto.BlogCreateRequest;
import com.example.dockerstudy.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitData {

    @Bean
    public CommandLineRunner initDevData(BlogService blogService) {
        return args -> {
            if(blogService.getList().size() > 0) {
                return;
            }
            blogService.create(new BlogCreateRequest("title1", "content1"));
            blogService.create(new BlogCreateRequest("title2", "content2"));
        };
    }
}
