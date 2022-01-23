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

    private String title;

    private String content;

    private LocalDateTime createdAt;

    private String username;

    public Board toEntity() {

        return Board.builder()
                .content(this.content)
                .username(this.username)
                .title(this.title)
                .build();
    }
}
