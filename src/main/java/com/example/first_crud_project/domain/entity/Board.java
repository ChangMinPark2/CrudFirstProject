package com.example.first_crud_project.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String bno;

    private String title;

    private String content;



    @ManyToOne
    private Member member;
}
