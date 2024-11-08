package com.example.spring.springbootbasicboard2.dto;

import com.example.spring.springbootbasicboard2.model.Board;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class BoardListResponseDTO {
    List<Board> boards;
    boolean last;
}
