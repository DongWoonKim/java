package com.example.tobi.springbootbasicboard.controller;

import com.example.tobi.springbootbasicboard.dto.BoardDeleteRequestDTO;
import com.example.tobi.springbootbasicboard.dto.BoardDetailResponseDTO;
import com.example.tobi.springbootbasicboard.dto.BoardListResponseDTO;
import com.example.tobi.springbootbasicboard.model.Board;
import com.example.tobi.springbootbasicboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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
                .filePath(boardDetail.getFilePath())
                .build();
    }

    @PostMapping
    public ResponseEntity<Void> saveArticle(
            @RequestParam("title") String title,
            @RequestParam("hiddenUserId") String userId,
            @RequestParam("content") String content,
            @RequestPart("file") MultipartFile file
    ) {
        boardService.saveArticle(userId, title, content, file);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/file/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) throws UnsupportedEncodingException {
        Resource resource = boardService.downloadFile(fileName);

        // 한글 파일명을 URL 인코딩
        String encodedFileName = URLEncoder.encode(resource.getFilename(), StandardCharsets.UTF_8.toString());

        // 파일 다운로드 처리
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename*=UTF-8''" + encodedFileName)
                .body(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArticle(
            @PathVariable long id,
            @RequestBody BoardDeleteRequestDTO request
    ) {
        boardService.deleteArticle(id, request);
        return ResponseEntity.ok("게시글이 성공적으로 삭제되었습니다.");
    }

}
