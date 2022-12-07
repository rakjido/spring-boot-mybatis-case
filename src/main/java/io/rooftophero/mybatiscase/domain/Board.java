package io.rooftophero.mybatiscase.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@ToString
public class Board {

    private Long id;

    private String title;

    private String content;

//    private BoardType boardType;
    private String boardType;

    private String userId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updatedDate;
}
