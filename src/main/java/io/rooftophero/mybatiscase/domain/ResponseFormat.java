package io.rooftophero.mybatiscase.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class ResponseFormat<T> {
    private String message;
    private List<T> data;
}
