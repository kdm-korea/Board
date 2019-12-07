package com.board.webservice.service;


import com.board.webservice.dto.posts.PostsSaveRequestDto;
import com.board.webservice.web.domain.posts.Posts;
import com.board.webservice.web.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import static org.junit.Assert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

    @Autowired
     private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    //@After
    //public void claenup(){
    //    postsRepository.deleteAll();
    //}

    @Test
    public void DTO데이터가_posts테이블에_저장된다(){
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("kdm_korea@naver.com")
                .content("테스트")
                .title("테스트 타이틀")
                .build();

        //when
        postsService.save(dto);

        //then
        Posts post = postsRepository.findAll().get(0);
        assertThat(post.getAuthor()).isEqualTo("kdm_korea@naver.com");
        assertThat(post.getContent()).isEqualTo(dto.getContent());
        assertThat(post.getTitle()).isEqualTo(dto.getTitle());
    }
}
