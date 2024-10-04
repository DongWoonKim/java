package com.example.tobi.springbootbasicboard.controller;

import com.example.tobi.springbootbasicboard.dto.BoardDetailResponseDTO;
import com.example.tobi.springbootbasicboard.dto.BoardListResponseDTO;
import com.example.tobi.springbootbasicboard.model.Board;
import com.example.tobi.springbootbasicboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardApiController {

    private final BoardService boardService;

    @GetMapping
    public BoardListResponseDTO getBoardList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        // 게시글 목록 가져오기
        List<Board> boards = boardService.getBoardList(page, size);

        // 전체 게시글 수 가져오기
        int totalBoards = boardService.getTotalBoards();

        // 마지막 페이지 여부 계산
        boolean last = (page * size) >= totalBoards;

        return BoardListResponseDTO.builder()
                .boards(boards)
                .last(last)
                .build();
    }


    @GetMapping("/{id}")
    public BoardDetailResponseDTO getBoardDetail(@PathVariable long id) {
        Board boardDetail = boardService.getBoardDetail(id);
        return BoardDetailResponseDTO.builder()
                .title(boardDetail.getTitle())
                .content(boardDetail.getContent())
                .created(boardDetail.getCreated())
                .userId(boardDetail.getUserId())
                .build();
    }

}
