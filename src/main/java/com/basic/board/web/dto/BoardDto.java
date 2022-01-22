package com.basic.board.web.dto;

import com.basic.board.domain.entity.Board;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDto {

    @Size(max = 10, message = "제목은 10글자 이하여야 합니다")
    private String title;

    @NotBlank(message = "내용을 입력해 주세요")
    @Size(max = 50, message = "내용은 50글자 이하여야 합니다")
    private String content;

    @NotBlank(message = "이름을 입력해 주세요")
    @Size(max = 6, message = "이름은 6글자 이하여야 합니다")
    private String username;

    public Board toEntity() {

        return Board.builder()
                .content(this.content)
                .username(this.username)
                .title(this.title)
                .build();
    }
}
