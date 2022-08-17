package com.example.first_crud_project.controller;


import com.example.first_crud_project.domain.dto.ReadDto;
import com.example.first_crud_project.domain.dto.SignUpDto;
import com.example.first_crud_project.domain.dto.UpdateDto;
import com.example.first_crud_project.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signUp")
    public void signUp(SignUpDto signUpDto){
        memberService.signUp(signUpDto);
    }

    @PutMapping("/update")
    public void update(UpdateDto updateDto){
        memberService.update(updateDto);
    }

    @GetMapping
    public ReadDto read(String identity){
        return memberService.getMember(identity);
    }
}
