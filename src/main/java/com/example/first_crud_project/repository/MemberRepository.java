package com.example.first_crud_project.repository;

import com.example.first_crud_project.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    //TODO : Optional로 감싸서 받는다는 것 공부하기 왜? -> Optional<Member> findByIdnetity(String identity)
    Member findByIdentity(String identity);
}
