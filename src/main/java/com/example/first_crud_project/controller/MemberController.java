package com.example.first_crud_project.controller;


import com.example.first_crud_project.domain.dto.DeleteDto;
import com.example.first_crud_project.domain.dto.ReadDto;
import com.example.first_crud_project.domain.dto.SignUpDto;
import com.example.first_crud_project.domain.dto.UpdateDto;
import com.example.first_crud_project.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController //TODO : Controller와 RestController 차이
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //TODO : RequestBody 란?
    @PostMapping("/signUp")
    public void signUp(@RequestBody SignUpDto signUpDto){
        memberService.signUp(signUpDto);
    }

    @PutMapping("/update")
    public void update(UpdateDto updateDto){
        memberService.update(updateDto);
    }

    //TODO : RequestParam 이란?
    @GetMapping
    public ReadDto read(@RequestParam("identity") String identity){
        return memberService.getMember(identity);
    }

    @DeleteMapping
    public void delete(DeleteDto deleteDto){
        memberService.delete(deleteDto);
    }

}
