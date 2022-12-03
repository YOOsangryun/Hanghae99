package com.sparta.board.controller;

import com.sparta.board.dto.PostDeleteRequestDto;
import com.sparta.board.dto.PostDeleteResponseDto;
import com.sparta.board.dto.PostRequestDto;
import com.sparta.board.dto.PostResponseDto;
import com.sparta.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/api/posts") // 전체 게시글 목록 조회
    public List<PostResponseDto> getPosts() {
        return postService.getPosts();
    }

    @PostMapping("/api/post") // 게시글 작성
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto){
        return postService.creatPost(requestDto);
    }


    @GetMapping("/api/post/{id}") // 선택한 게시글 조회
    //@PathVariable => {id}에 들어오는 값을 Long id에 담아줌 (받을데이터가 1개일때)
    //@requestBody => json 형식 (받을 데이터가 여러개일때)
    public PostResponseDto getPost(@PathVariable Long id){
        return postService.getPost(id);
    }

    @PutMapping("/api/post/{id}") //선택한 게시글 수정
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        return postService.updatePost(id, requestDto);
    }

    @DeleteMapping("/api/post/{id}") //선택한 게시글 삭제
    public PostDeleteResponseDto deletePost(@PathVariable Long id, @RequestBody PostDeleteRequestDto requestDto){
        boolean deleteResult = postService.deletePost(id, requestDto.getPassword());
        return new PostDeleteResponseDto(deleteResult);
    }
}