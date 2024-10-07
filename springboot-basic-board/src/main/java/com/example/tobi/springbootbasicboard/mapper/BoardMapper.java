package com.example.tobi.springbootbasicboard.mapper;

import com.example.tobi.springbootbasicboard.model.Board;
import com.example.tobi.springbootbasicboard.model.Paging;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> selectBoardList(Paging page);
    int countBoards();
    Board selectBoardDetail(long id);
    void saveArticle(Board board);
    void deleteBoardById(long id);
}
