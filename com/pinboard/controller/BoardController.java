package com.pinboard.controller;

import com.pinboard.dto.BoardDTO;
import com.pinboard.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public ResponseEntity<List<BoardDTO>> getAllBoards() {
        return ResponseEntity.ok(boardService.getAllBoards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardDTO> getBoardById(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.getBoardById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BoardDTO>> getBoardsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(boardService.getBoardsByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<BoardDTO> createBoard(@RequestBody BoardDTO boardDTO) {
        return new ResponseEntity<>(boardService.createBoard(boardDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardDTO> updateBoard(@PathVariable Long id, @RequestBody BoardDTO boardDTO) {
        boardDTO.setId(id);
        return ResponseEntity.ok(boardService.updateBoard(boardDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{boardId}/pins/{pinId}")
    public ResponseEntity<BoardDTO> addPinToBoard(@PathVariable Long boardId, @PathVariable Long pinId) {
        return ResponseEntity.ok(boardService.addPinToBoard(boardId, pinId));
    }

    @DeleteMapping("/{boardId}/pins/{pinId}")
    public ResponseEntity<BoardDTO> removePinFromBoard(@PathVariable Long boardId, @PathVariable Long pinId) {
        return ResponseEntity.ok(boardService.removePinFromBoard(boardId, pinId));
    }
}