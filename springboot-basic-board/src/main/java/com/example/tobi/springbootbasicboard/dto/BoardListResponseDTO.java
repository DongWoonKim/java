package com.example.tobi.springbootbasicboard.dto;

import com.example.tobi.springbootbasicboard.model.Board;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class BoardListResponseDTO {
    List<Board> boards;
    boolean last;
}
