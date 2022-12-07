package io.rooftophero.mybatiscase.service;

import io.rooftophero.mybatiscase.domain.Board;
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
}
