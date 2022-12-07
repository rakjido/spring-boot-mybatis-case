package io.rooftophero.mybatiscase.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BoardType {
    notice(0, "공지사항", "공지사항"),
    free(1, "자유게시판", "자유게시판")
    ;

    private Integer id;
    private String title;
    private String description;
}
