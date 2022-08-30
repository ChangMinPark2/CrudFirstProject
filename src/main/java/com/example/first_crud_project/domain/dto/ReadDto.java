package com.example.first_crud_project.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ReadDto { //회원정보조회

    private String name;
    private String identity;
    private String email;
    private String cellphone;
    private String address;

    @Builder
    public ReadDto(String name, String identity, String email, String cellphone, String address) {
        this.name = name;
        this.identity = identity;
        this.email = email;
        this.email = cellphone;
        this.address = address;
        //TODO : 빌더부분
    }
}
