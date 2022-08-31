package com.example.first_crud_project.domain.entity;
import lombok.*;

import javax.persistence.*;

@Getter
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

    private String email;

    private String address;

    private String cellPhone;



    //TODO : Builder 패턴이란?
    @Builder
    public Member(String identity, String password, String name) {
        this.identity = identity;
        this.password = password;
        this.name = name;
    }

    public void updateMember(String name, String email, String address, String cellphone) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.cellPhone = cellPhone;
    }


}
