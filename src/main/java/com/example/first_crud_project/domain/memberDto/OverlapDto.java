package com.example.first_crud_project.domain.memberDto;

import lombok.Getter;

@Getter
public class OverlapDto {
    //중복회원조회
    //이름과 상관없이 우선은 아이디가 같으면 안된다.
    private String identity;
}
