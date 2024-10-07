package com.example.tobi.springbootbasicboard.service;

import com.example.tobi.springbootbasicboard.mapper.BoardMapper;
import com.example.tobi.springbootbasicboard.model.Board;
import com.example.tobi.springbootbasicboard.model.Paging;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;
    private final FileService fileService;

    public List<Board> getBoardList(int page, int size) {
        int offset = (page - 1) * size; // 페이지는 1부터 시작, offset 계산
        return boardMapper.selectBoardList(
                Paging.builder()
                        .offset(offset)
                        .size(size)
                        .build()
        );
    }

    public int getTotalBoards() {
        return boardMapper.countBoards(); // 총 게시글 수 반환
    }

    public Board getBoardDetail(long id) {
        return boardMapper.selectBoardDetail(id);
    }

    public void saveArticle(String userId, String title, String content, MultipartFile file) {
        String path = null;

        if (!file.isEmpty()) {
            path = fileService.fileUpload(file);
        }

        boardMapper.saveArticle(
                Board.builder()
                        .title(title)
                        .content(content)
                        .userId(userId)
                        .filePath(path)
                        .build()
        );

    }
}
