package com.sparta.board.dto;

import lombok.Getter;

@Getter
public class PostDeleteResponseDto {
    private Boolean success;

    public PostDeleteResponseDto(Boolean result){
        this.success = result;
    }
}