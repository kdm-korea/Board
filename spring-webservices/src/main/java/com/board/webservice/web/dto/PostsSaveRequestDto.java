package com.board.webservice.web.dto;

import com.board.webservice.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String titile;
    private String content;
    private String author;

    public Posts toEntity(){
        return Posts.builder()
                .title(titile)
                .content(content)
                .author(author)
                .build();
    }
}
