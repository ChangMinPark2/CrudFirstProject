package com.example.first_crud_project.repository;

import javax.persistence.EntityManager;

public class JpaMemberRepository {

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }
}
