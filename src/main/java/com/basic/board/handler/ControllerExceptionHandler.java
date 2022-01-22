package com.basic.board.handler;

import com.basic.board.handler.ex.ExceptionRes;
import com.basic.board.handler.ex.NotExistException;
import com.basic.board.web.dto.ResDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import javax.validation.ConstraintViolationException;

@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResDto methodArgumentNotValidException(MethodArgumentNotValidException e) {

        return new ResDto(-1, "Invalid Input Value",
                ExceptionRes.of(e.getBindingResult()));
    }

//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResDto constraintViolationException(ConstraintViolationException e) {
//
//        return new ResDto(-1, "Invalid Input Value",
//                ExceptionRes.of(e.getConstraintViolations()));
//    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResDto methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {

        return new ResDto(-2, "Invalid URL Value",
                ExceptionRes.of(e.getName(),e.getMessage()));
    }

    @ExceptionHandler(NotExistException.class)
    public ResDto notExistException(NotExistException e){

        return new ResDto(-1, "not exist",
                ExceptionRes.of(e.getField(),e.getReason()));
    }
}
