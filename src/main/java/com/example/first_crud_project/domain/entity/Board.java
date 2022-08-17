package com.example.first_crud_project.domain.entity;

import javax.persistence.*;

@Entity
@Table

public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bno;
    private long title;
    private long content;

    @ManyToOne
    private Member member;
}
