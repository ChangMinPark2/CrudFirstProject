package com.example.first_crud_project.domain.memberDto;

import lombok.Getter;

@Getter
public class UpdateDto { //회원수정
    private String name;

    private String identity;

    private String email;

    private String address;

    private String password;

    private String cellPhone;
}
