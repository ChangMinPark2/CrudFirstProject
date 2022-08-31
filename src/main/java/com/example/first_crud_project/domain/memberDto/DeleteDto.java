package com.example.first_crud_project.domain.memberDto;


import lombok.Getter;

@Getter
public class DeleteDto { //회원삭제 -> 아이디와 비밀번호를 보내주고 회원정보 삭제
    private String identity;

    private String password;
}
