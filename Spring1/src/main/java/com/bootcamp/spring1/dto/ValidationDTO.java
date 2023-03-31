package com.bootcamp.spring1.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidationDTO {

    private String message;

    private String action;
}
