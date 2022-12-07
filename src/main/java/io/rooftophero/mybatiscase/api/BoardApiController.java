package io.rooftophero.mybatiscase.api;

import io.rooftophero.mybatiscase.domain.Board;
import io.rooftophero.mybatiscase.domain.ResponseFormat;
import io.rooftophero.mybatiscase.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("/api/boards")
    public ResponseEntity<?> addBoard(@RequestBody Board board) {
        try {
            boardService.addBoard(board);
            ResponseFormat<String> response = ResponseFormat.<String>builder().message("added successfully").build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            ResponseFormat<String> response = ResponseFormat.<String>builder().message(e.getMessage()).build();
            return ResponseEntity.badRequest().body(response);
        }

    }

    @GetMapping("/api/boards/{id}")
    public ResponseEntity<?> findBoard(@PathVariable("id") Long id) {
        try {
            List<Board> board = boardService.findBoard(id);
            ResponseFormat<Board> response = ResponseFormat.<Board>builder().message("ok").data(board).build();
            return ResponseEntity.ok().body(response);
//            Board board = boardService.findBoard(id);
//            return ResponseEntity.ok().body(board);
        } catch (Exception e) {
            ResponseFormat<String> response = ResponseFormat.<String>builder().message(e.getMessage()).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/api/boards")
    public ResponseEntity<?> modifyBoard(@RequestBody Board board) {
        try {
            boardService.modifyBoard(board);
            ResponseFormat<String> response = ResponseFormat.<String>builder().message("modified successfully").build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            ResponseFormat<String> response = ResponseFormat.<String>builder().message(e.getMessage()).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/api/boards")
    public ResponseEntity<?> removeBoard(@RequestBody Board board) {
        try {
            boardService.removeBoard(board);
            ResponseFormat<String> response = ResponseFormat.<String>builder().message("removed successfully").build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            ResponseFormat<String> response = ResponseFormat.<String>builder().message(e.getMessage()).build();
            return ResponseEntity.badRequest().body(response);
        }

    }

    @GetMapping("/api/boards")
    public ResponseEntity<?> listBoard(){
        try {
            List<Board> boards = boardService.listBoard();
            ResponseFormat<Board>  response = ResponseFormat.<Board>builder().message("ok").data(boards).build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            ResponseFormat<String> response = ResponseFormat.<String>builder().message(e.getMessage()).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
}
