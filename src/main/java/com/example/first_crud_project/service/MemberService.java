package com.example.first_crud_project.service;

import com.example.first_crud_project.domain.dto.ReadDto;
import com.example.first_crud_project.domain.dto.SignUpDto;
import com.example.first_crud_project.domain.dto.UpdateDto;
import com.example.first_crud_project.domain.entity.Member;
import com.example.first_crud_project.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void signUp(SignUpDto signUpDto){
        //TODO 회원 가입 기능
        Member member =Member.builder()
                .identity(signUpDto.getIdentity())
                .name(signUpDto.getName())
                .password(signUpDto.getPassword())
                .build();

        memberRepository.save(member);
    }

    public void update(UpdateDto updateDto){
        Member member = memberRepository.findByIdentity(updateDto.getIdentity());

        member.updateName(updateDto.getName()); // 홍길동에서 홍준표로 바뀌는 부분
        memberRepository.save(member);
    }

    public ReadDto getMember(String identity){
        Member member = memberRepository.findByIdentity(identity);

        ReadDto readDto = ReadDto.builder()
                .identity(member.getIdentity())
                .build();

        return readDto;
    }
}
