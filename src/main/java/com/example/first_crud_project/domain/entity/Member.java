package com.example.first_crud_project.domain.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
@Getter
@Entity
@Table


public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mno;
    private String identity;
    private String password;
    private String name;

    public void updateName(String name){
        this.name = name;
    }

    @Builder
    public Member(String identity, String password, String name) {
        this.identity = identity;
        this.password = password;
        this.name = name;
    }
}
