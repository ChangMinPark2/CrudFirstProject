package com.example.first_crud_project.domain.memberDto;


import lombok.Getter;

@Getter

public class SignUpDto { //회원가입
    private String identity;

    private String name;

    private String password;
}
