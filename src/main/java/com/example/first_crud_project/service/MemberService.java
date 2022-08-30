package com.example.first_crud_project.service;

import com.example.first_crud_project.domain.dto.*;
import com.example.first_crud_project.domain.entity.Member;
import com.example.first_crud_project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
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
        //TODO : 예외처리 1 2 3 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        memberRepository.save(member);

    }
    //회원 수정 기능
    public void update(UpdateDto updateDto){
        //TODO : 예외처리
        if(updateDto.getIdentity() == null || updateDto.getEmail() == null || updateDto.getCellphone() == null ||
                updateDto.getEmail() == null ||updateDto.getName() == null ||updateDto.getPassword() ==null){
            System.out.println("필수항목을 작성하지 않았습니다.");
        }
        Member member = memberRepository.findByIdentity(updateDto.getIdentity());
        if(member == null){// TODO : 궁금한점 -> 여기서 member.getIdentity를 안한이유는 이미 위에서 updateDto에서 identity를 가져와서인가.?
            System.out.println("해당 아이디는 존재하지 않습니다.");
        }
        //TODO : 궁금한점 -> 위에 코드로 인해 이미 아이디는 일치하고, 내려온 경우인가? 당연한거지만 확실하게 잡쟈.
        if(!updateDto.getPassword().equals((member.getPassword()))){
            System.out.println("비밀번호가 일치하지 않습니다.");
        }

        //Boolean isExistName = memberRepository.existsByName(updateDto.getName());
        //Boolean isExistCellphone = memberRepository.existsByCellPhone(updateDto.getCellphone());

        if(updateDto.getCellphone().equals(member.getCellphone())){
            System.out.println("중복된 전화번호입니다.");
        }
        if(updateDto.getName().equals(member.getName())){
            System.out.println("중복된 이름입니다.");
        }
    member.updateName(updateDto.getName(), updateDto.getEmail(), updateDto.getCellphone(), updateDto.getAddress());
      //  member.updateName(updateDto.getName()); // 홍길동에서 홍준표로 바뀌는 부분
        memberRepository.save(member);
    }

    // 회원 정보 조회
    public ReadDto getMember(String identity){
        Member member = memberRepository.findByIdentity(identity);

        //TODO : 밑에 코드만으로 회원 이름, 이메일 주소 폰번호가 조회가 되는가 ?

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

   // public OverlapDto overlapDto(String identity){
     //   Member member = memberRepository.findByIdentity(identity);
       // if(identity == overlapDto.getIdentity(identity)){
        //}

        //TODO : 예외처리 중복회원기능
}


