package com.example.first_crud_project.repository;

import com.example.first_crud_project.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataMemberRepository extends JpaRepository<Member, Long> {


    Optional<Member> findByName(String name);
}
