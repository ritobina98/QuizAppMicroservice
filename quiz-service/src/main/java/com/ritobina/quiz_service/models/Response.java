package com.ritobina.quiz_service.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Response {
    private Integer id;
    private String response;
}
