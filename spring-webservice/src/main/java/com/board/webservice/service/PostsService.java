package com.board.webservice.service;

import com.board.webservice.dto.posts.PostsSaveRequestDto;
import com.board.webservice.web.domain.posts.PostsRepository;
import com.sun.tools.javac.jvm.ByteCodes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }
}
