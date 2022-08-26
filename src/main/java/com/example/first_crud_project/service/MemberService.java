package com.example.first_crud_project.service;

import com.example.first_crud_project.domain.dto.*;
import com.example.first_crud_project.domain.entity.Member;
import com.example.first_crud_project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//회원 가입
    public void signUp(SignUpDto signUpDto){
        Boolean isExistIdentity = memberRepository.existsByIdentity(signUpDto.getIdentity());

        if(isExistIdentity){
            System.out.println("아이디가 중복되었습니다.");
        }

        Member member =Member.builder()
                .identity(signUpDto.getIdentity())
                .name(signUpDto.getName())
                .password(signUpDto.getPassword())
                .build();
        //TODO : 예외처리
        memberRepository.save(member);

    }
    //회원 수정 기능
    public void update(UpdateDto updateDto){
        Member member = memberRepository.findByIdentity(updateDto.getIdentity());

        //TODO : 예외처리

        member.updateName(updateDto.getName()); // 홍길동에서 홍준표로 바뀌는 부분
        memberRepository.save(member);
    }

    // 회원 정보 조회
    public ReadDto getMember(String identity){
        Member member = memberRepository.findByIdentity(identity);

        //TODO : 예외처리

        ReadDto readDto = ReadDto.builder()
                .identity(member.getIdentity())
                .build();
        return readDto;
    }

    //회원 삭제 기능
    public void delete(DeleteDto deleteDto){
        Member member = memberRepository.findByIdentity(deleteDto.getIdentity());
        if(member == null){
            System.out.println("해당아이디는 없습니다.");
        }
        if(deleteDto.getPassword() != member.getPassword()){
            System.out.println("비밀번호가 틀렸습니다.");
        }
        memberRepository.delete(member);
    }
/*
    public OverlapDto overlapDto(String identity){
        Member member = memberRepository.findByIdentity(identity);
        if(identity == overlapDto.getIdentity(identity)){
        }
    }
*/
}
