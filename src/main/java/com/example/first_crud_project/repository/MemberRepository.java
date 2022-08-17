package com.example.first_crud_project.repository;

import com.example.first_crud_project.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByIdentity(String identity);

}
