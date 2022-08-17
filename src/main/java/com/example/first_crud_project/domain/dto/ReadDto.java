package com.example.first_crud_project.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ReadDto {

    private final String name;
    private final String identity;

    @Builder
    public ReadDto(String name, String identity) {
        this.name = name;
        this.identity = identity;
    }
}
