package com.basic.board.handler.ex;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NotExistException extends RuntimeException {

    private String field;
    private String reason;

}
