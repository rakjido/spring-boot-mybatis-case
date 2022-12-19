package io.rooftophero.mybatiscase.api;

import io.rooftophero.mybatiscase.domain.Board;
import io.rooftophero.mybatiscase.domain.Pagination;
import io.rooftophero.mybatiscase.domain.ResponseFormat;
import io.rooftophero.mybatiscase.service.BoardService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"1. Board"})
@RestController
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    @ApiOperation(value = "Board 추가", notes = "Board를 추가한다.")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "성공"),
//            @ApiResponse(code = 201, message = "Board를 성공적으로 추가", response = ResponseFormat.class),
//            @ApiResponse(code = 400, message = "잘못된 데이터를 입력했습니다.", response = ErrorFormat.class),
//            @ApiResponse(code = 401, message = "사용자 로그인을 하지 않았습니다.", response = ErrorFormat.class),
//            @ApiResponse(code = 403, message = "사용권한이 없습니다.", response = ErrorFormat.class)})
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

    @ApiOperation(value = "Board 조회", notes = "특정 ID의 Board를 조회한다.")
    @GetMapping("/api/boards/{id}")
    public ResponseEntity<?> findBoard(@ApiParam(value = "Board ID", required = true, example = "1" ) @PathVariable("id") Long id) {
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

    @ApiOperation(value = "Board 수정", notes = "Board를 업데이트한다.")
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

    @ApiOperation(value = "Board 삭제", notes = "특정한 Board를 삭제한다.")
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

    @ApiOperation(value = "Board 리스트 페이지 조회", notes = "Board 리스트 페이지를 조회한다.")
    @GetMapping("/api/boards")
    public ResponseEntity<?> listBoardPagination(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                                                 @RequestParam(value = "size", defaultValue = "10") int pageSize) {
        try {
            int totalNumber = boardService.totalCountBoard();
            Pagination pagination = Pagination.builder()
                                                .pageNumber(pageNumber)
                                                .pageSize(pageSize)
                                                .totalNumber(totalNumber)
                                                .build();
            List<Board> boards = boardService.listBoardPagination(pagination);
            ResponseFormat<Board>  response = ResponseFormat.<Board>builder().message("ok").data(boards).build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            ResponseFormat<String> response = ResponseFormat.<String>builder().message(e.getMessage()).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

//    @ApiOperation(value = "Board 리스트 조회", notes = "Board 리스트를 조회한다.")
//    @GetMapping("/api/boards")
//    public ResponseEntity<?> listBoard(){
//        try {
//            List<Board> boards = boardService.listBoard();
//            ResponseFormat<Board>  response = ResponseFormat.<Board>builder().data(boards).build();
//            return ResponseEntity.ok().body(response);
//        } catch (Exception e) {
//            ResponseFormat<String> response = ResponseFormat.<String>builder().message(e.getMessage()).build();
//            return ResponseEntity.badRequest().body(response);
//        }
//    }

//    @ApiOperation(value = "Board 리스트 페이지 조회", notes = "Board 리스트 페이지를 조회한다.")
//    @GetMapping("/api/boards")
//    public ResponseEntity<?> listBoardPagination(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
//                                                 @RequestParam(value = "size", defaultValue = "10") int pageSize) {
//        try {
//            List<Board> boards = boardService.listBoardPagination(pageNumber, pageSize);
//            ResponseFormat<Board>  response = ResponseFormat.<Board>builder().data(boards).build();
//            return ResponseEntity.ok().body(response);
//        } catch (Exception e) {
//            ResponseFormat<String> response = ResponseFormat.<String>builder().message(e.getMessage()).build();
//            return ResponseEntity.badRequest().body(response);
//        }
//    }

}
