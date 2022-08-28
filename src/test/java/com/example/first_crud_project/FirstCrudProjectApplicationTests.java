package com.example.first_crud_project;

import com.example.first_crud_project.domain.entity.Member;
import com.example.first_crud_project.repository.MemberRepository;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class FirstCrudProjectApplicationTests

    private final MemberRepository memberRepository;

    @Autowired
    public FirstCrudProjectApplicationTests(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Test
        void 회원가입() {
            // 멤버 저장
            Member member = new Member();
            member.setName("박창민");
            memberRepository.save(member);

            // 저장한 멤버 아이디로 검색
            Member findMember = memberRepository.findByIdentity(member.getIdentity()).get();
            Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
        ]


}
