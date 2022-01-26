package com.basic.board.domain.entity;

import com.basic.board.web.dto.BoardReqDto;
import com.basic.board.web.dto.BoardResDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(indexes = {
        @Index(name = "idx_created_at", columnList = "created_at"),
        @Index(name = "idx_updated_at", columnList = "updated_at")
})
public class Board extends TimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_id")
    private Integer id;

    @NotBlank
    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String title;

    //TODO: 유저 엔티티로 교체

    @NotBlank
    @Column(name="user_name", nullable = false, columnDefinition = "varchar(12)")
    private String username;

    @NotBlank
    @Column(nullable = false, columnDefinition = "varchar(100)")
    private String content;

    @Builder
    public Board(String title, String username, String content) {
        this.title = title;
        this.username = username;
        this.content = content;
    }

    public BoardReqDto toReqDto(){
        return BoardReqDto.builder()
                .content(this.content)
                .title(this.title)
                .username(this.username)
                .build();
    }

    public BoardResDto toResDto(){
        return BoardResDto.builder()
                .id(this.id)
                .content(this.content)
                .title(this.title)
                .username(this.username)
                .createdAt(this.createdAt)
                .build();
    }

}
