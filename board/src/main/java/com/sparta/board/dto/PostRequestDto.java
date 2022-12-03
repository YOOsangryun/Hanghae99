package com.sparta.board.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private Long id;
    private String title;
    private String author;
    private String content;
    private String password;
}