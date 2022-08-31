package com.example.first_crud_project.controller;


import com.example.first_crud_project.domain.memberDto.*;
import com.example.first_crud_project.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;


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

    @DeleteMapping("/delete")
    public void delete(DeleteDto deleteDto){
        memberService.delete(deleteDto);
    }
  //  @GetMapping
   // public OverlapDto overlapDto(@RequestParam("identity") String identity){
   //     return memberService.overlapDto(identity);
   // }

}

