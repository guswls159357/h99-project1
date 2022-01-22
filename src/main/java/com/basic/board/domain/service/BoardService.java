package com.basic.board.domain.service;

import com.basic.board.domain.entity.Board;
import com.basic.board.domain.repository.BoardRepository;
import com.basic.board.handler.ex.NotExistException;
import com.basic.board.web.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
@Slf4j
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public BoardDto create(BoardDto dto) {

        Board createdBoard = dto.toEntity();

        return boardRepository.save(createdBoard).toDto();
    }

    public List<BoardDto> getList() {

        return boardRepository.findAll().stream().map(board -> board.toDto())
                .collect(Collectors.toList());
    }

    public BoardDto getOne(Integer boardId) {

        Board board = boardRepository.findById(boardId)
                .orElseThrow(()->{
                    throw new NotExistException("boardId","존재하지 않습니다.");
                });

        return board.toDto();
    }
}
