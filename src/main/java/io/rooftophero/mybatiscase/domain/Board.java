package io.rooftophero.mybatiscase.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@ToString
@ApiModel(value = "Board information", description = "Title, Content, board type, user id를 가진 Board Domain")
public class Board {

    private Long id;

    @ApiModelProperty(value = "타이틀", required = true, example = "먼저 읽어보세요")
    private String title;

    @ApiModelProperty(value = "콘텐트", required = true)
    private String content;

    @ApiModelProperty(value = "Board 유형", required = true, example = "공지사항")
//    private BoardType boardType;
    private String boardType;

    @ApiModelProperty(value = "User id", required = true)
    private String userId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updatedDate;
}
