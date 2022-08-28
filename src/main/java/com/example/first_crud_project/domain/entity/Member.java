package com.example.first_crud_project.domain.entity;
import lombok.*;

import javax.persistence.*;

@Setter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    //TODO : COLUMN
    private String identity;

    private String password;

    private String name;

    //TODO : 필드 추가.

    //TODO : Builder 패턴이란?
    @Builder
    public Member(String identity, String password, String name) {
        this.identity = identity;
        this.password = password;
        this.name = name;
    }

    public void updateName(String name) {
        this.name = name;
    }


}
