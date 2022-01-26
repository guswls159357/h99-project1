package com.basic.board.web.controller;

import com.basic.board.domain.service.BoardService;
import com.basic.board.web.dto.BoardReqDto;
import com.basic.board.web.dto.BoardResDto;
import com.basic.board.web.dto.ResDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
@Slf4j
public class BoardApiController {

    private final BoardService boardService;

    @GetMapping
    public ResDto getBoardList() {

        List<BoardResDto> list = boardService.getList();

        return new ResDto(1, "success", list);

    }

    @GetMapping("/{boardId}")
    public ResDto getBoard(@PathVariable("boardId") @Valid Integer boardId) {

        BoardResDto board = boardService.getOne(boardId);

        return new ResDto(1, "success", board);
    }

    @PostMapping
    public ResDto create(@RequestBody @Validated BoardReqDto dto,
                         BindingResult bindingResult) throws MethodArgumentNotValidException {

        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(null,bindingResult);
        } else {
            BoardResDto created = boardService.create(dto);
            return new ResDto(1
                    , "success", created);
        }

    }


}
