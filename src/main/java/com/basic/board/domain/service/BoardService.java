package com.basic.board.domain.service;

import com.basic.board.domain.entity.Board;
import com.basic.board.domain.repository.BoardRepository;
import com.basic.board.handler.ex.NotExistException;
import com.basic.board.web.dto.BoardReqDto;
import com.basic.board.web.dto.BoardResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public BoardResDto create(BoardReqDto dto) {

        Board createdBoard = dto.toEntity();

        return boardRepository.save(createdBoard).toResDto();
    }

    public List<BoardResDto> getList() {

        return boardRepository.findAllOrderByCreatedAt().stream().map(board -> board.toResDto())
                .collect(Collectors.toList());
    }

    public BoardResDto getOne(Integer boardId) {

        Board board = boardRepository.findById(boardId)
                .orElseThrow(()->{
                    throw new NotExistException("boardId","존재하지 않습니다.");
                });

        return board.toResDto();
    }
}
