// BoardServiceImpl.java
package com.pinboard.service.board;

import com.pinboard.dto.BoardDTO;
import com.pinboard.model.Board;
import com.pinboard.model.Pin;
import com.pinboard.repository.BoardRepository;
import com.pinboard.repository.PinRepository;
import com.pinboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final PinRepository pinRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository, UserRepository userRepository, PinRepository pinRepository) {
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
        this.pinRepository = pinRepository;
    }

    @Override
    public List<BoardDTO> getAllBoards() {
        return boardRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BoardDTO getBoardById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Board not found with id: " + id));
        return convertToDTO(board);
    }

    @Override
    public List<BoardDTO> getBoardsByUserId(Long userId) {
        return boardRepository.findByUserId(userId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public BoardDTO createBoard(BoardDTO boardDTO) {
        Board board = new Board();
        board.setName(boardDTO.getName());
        board.setDescription(boardDTO.getDescription());
        board.setUser(userRepository.findById(boardDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + boardDTO.getUserId())));
        
        Board savedBoard = boardRepository.save(board);
        return convertToDTO(savedBoard);
    }

    @Override
    @Transactional
    public BoardDTO updateBoard(BoardDTO boardDTO) {
        Board board = boardRepository.findById(boardDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Board not found with id: " + boardDTO.getId()));
        
        board.setName(boardDTO.getName());
        board.setDescription(boardDTO.getDescription());
        
        Board updatedBoard = boardRepository.save(board);
        return convertToDTO(updatedBoard);
    }

    @Override
    @Transactional
    public void deleteBoard(Long id) {
        if (!boardRepository.existsById(id)) {
            throw new EntityNotFoundException("Board not found with id: " + id);
        }
        boardRepository.deleteById(id);
    }

    @Override
    @Transactional
    public BoardDTO addPinToBoard(Long boardId, Long pinId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new EntityNotFoundException("Board not found with id: " + boardId));
        
        Pin pin = pinRepository.findById(pinId)
                .orElseThrow(() -> new EntityNotFoundException("Pin not found with id: " + pinId));
        
        board.getPins().add(pin);
        Board updatedBoard = boardRepository.save(board);
        return convertToDTO(updatedBoard);
    }

    @Override
    @Transactional
    public BoardDTO removePinFromBoard(Long boardId, Long pinId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new EntityNotFoundException("Board not found with id: " + boardId));
        
        Pin pin = pinRepository.findById(pinId)
                .orElseThrow(() -> new EntityNotFoundException("Pin not found with id: " + pinId));
        
        board.getPins().remove(pin);
        Board updatedBoard = boardRepository.save(board);
        return convertToDTO(updatedBoard);
    }

    private BoardDTO convertToDTO(Board board) {
        BoardDTO dto = new BoardDTO();
        dto.setId(board.getId());
        dto.setName(board.getName());
        dto.setDescription(board.getDescription());
        dto.setUserId(board.getUser().getId());
        
        if (board.getPins() != null) {
            dto.setPinIds(board.getPins().stream()
                .map(Pin::getId)
                .collect(Collectors.toList()));
        }
        
        return dto;
    }
}