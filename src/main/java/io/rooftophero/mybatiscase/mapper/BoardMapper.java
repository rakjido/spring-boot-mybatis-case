package io.rooftophero.mybatiscase.mapper;

import io.rooftophero.mybatiscase.domain.Board;

import java.util.List;

public interface BoardMapper {

    public void insertBoard(Board board);
    public List<Board> selectBoard(Long id);
    //    public Board selectBoard(Long id);
    public void updateBoard(Board board);
    public void deleteBoard(Board board);
    public List<Board> listBoard();
}
