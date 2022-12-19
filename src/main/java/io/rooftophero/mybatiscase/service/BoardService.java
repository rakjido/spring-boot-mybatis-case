package io.rooftophero.mybatiscase.service;

import io.rooftophero.mybatiscase.domain.Board;
import io.rooftophero.mybatiscase.domain.Pagination;
import io.rooftophero.mybatiscase.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    @Transactional
    public void addBoard(Board board) {
        boardMapper.insertBoard(board);
    }

    public List<Board> findBoard(Long id) {
        return boardMapper.selectBoard(id);
    }

//    public Board findBoard(Long id) {
//        return boardMapper.selectBoard(id);
//    }

    @Transactional
    public void modifyBoard(Board board) {
        boardMapper.updateBoard(board);
    }

    @Transactional
    public void removeBoard(Board board) {
        boardMapper.deleteBoard(board);
    }

    public List<Board> listBoard() {
        return boardMapper.listBoard();
    }

    public List<Board> listBoardPagination(Pagination pagination) {
        return boardMapper.listBoardPagination(pagination);
    }

//    public List<Board> listBoardPagination(Pagination pagination) {
//        return boardMapper.listBoardPagination(pagination.getPageNumber(), pagination.getPageSize());
//    }


//    public List<Board> listBoardPagination(int pageNumber, int pageSize) {
//        int totalNumber = boardMapper.totalCountBoard();
//        Pagination pagination = Pagination.builder()
//                                        .pageNumber(pageNumber)
//                                        .pageSize(pageSize)
//                                        .totalNumber(totalNumber)
//                                        .build();
//        return boardMapper.listBoardPagination(pagination.getPageNumber(), pagination.getPageSize());
//    }


    public int totalCountBoard() {
        return boardMapper.totalCountBoard();
    }

}
