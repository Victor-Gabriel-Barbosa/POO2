// BoardService.java
package com.pinboard.service.board;

import com.pinboard.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    List<BoardDTO> getAllBoards();
    BoardDTO getBoardById(Long id);
    List<BoardDTO> getBoardsByUserId(Long userId);
    BoardDTO createBoard(BoardDTO boardDTO);
    BoardDTO updateBoard(BoardDTO boardDTO);
    void deleteBoard(Long id);
    BoardDTO addPinToBoard(Long boardId, Long pinId);
    BoardDTO removePinFromBoard(Long boardId, Long pinId);
}