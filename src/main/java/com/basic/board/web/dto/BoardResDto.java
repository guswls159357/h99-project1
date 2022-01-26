package com.basic.board.web.dto;

import com.basic.board.domain.entity.Board;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardResDto {

    private Integer id;

    private String title;

    private String content;

    private LocalDateTime createdAt;

    private String username;

}
