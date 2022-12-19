package io.rooftophero.mybatiscase.mapper;

import io.rooftophero.mybatiscase.domain.Board;
import io.rooftophero.mybatiscase.domain.Pagination;

import java.util.List;

public interface BoardMapper {

    public void insertBoard(Board board);
    public List<Board> selectBoard(Long id);
    //    public Board selectBoard(Long id);
    public void updateBoard(Board board);
    public void deleteBoard(Board board);
    public List<Board> listBoard();
//    public List<Board> listBoardPagination(int pageNumber, int pageSize);
    public List<Board> listBoardPagination(Pagination pagination);
    public int totalCountBoard();
}
