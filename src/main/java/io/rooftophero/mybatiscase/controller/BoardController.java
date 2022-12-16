package io.rooftophero.mybatiscase.controller;

import io.rooftophero.mybatiscase.domain.Board;
import io.rooftophero.mybatiscase.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/boards/new")
    public String boardCreate() {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        log.info(getClass().getName() + " / " + methodName);
        return "boards/board_create";
    }

    @GetMapping("/boards/{id}")
    public String boardView(Model model, @PathVariable("id") Long id) {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        log.info(getClass().getName() + " / " + methodName);

        List<Board> boards = boardService.findBoard(id);
        if(boards.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Data Found");
        }
        Board board = boards.get(0);
        model.addAttribute("board", board);
        String lineSeparator = System.lineSeparator();
        model.addAttribute("lineSeparator", lineSeparator);
        return "boards/board_view";
    }

    @GetMapping("/boards/update/{id}")
    public String boardUpdate(Model model, @PathVariable("id") Long id) {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        log.info(getClass().getName() + " / " + methodName);

        List<Board> boards = boardService.findBoard(id);
        Board board = boards.get(0);
        model.addAttribute("board", board);
        return "boards/board_update";
    }

    @GetMapping("/boards")
    public String boardList(Model model) {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        log.info(getClass().getName() + " / " + methodName);

        List<Board> boards = boardService.listBoard();
        model.addAttribute("boards", boards);
        return "boards/board";
    }
}
