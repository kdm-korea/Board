package com.board.webservice.web;

import com.board.webservice.dto.posts.PostsSaveRequestDto;
import com.board.webservice.web.domain.posts.PostsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {

    PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello(){
        return "helloWorld";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
    }
}
