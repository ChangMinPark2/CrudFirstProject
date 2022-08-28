package com.example.first_crud_project.repository;

import com.example.first_crud_project.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    //TODO : Optional로 감싸서 받는다는 것 공부하기 왜? -> Optional<Member> findByIdnetity(String identity)
    Member findByIdentity(String identity);
    Member save(Member member);
    Optional<Member> findByName(String name);
    List<Member> findAll();
    Boolean existsByIdentity(String identity);
}
