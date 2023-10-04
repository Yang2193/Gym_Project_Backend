package com.personal.project.controller;

import com.personal.project.dto.MemberDto;
import com.personal.project.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signUp")
    public ResponseEntity<Boolean> signUp(@RequestBody MemberDto memberDto){
        boolean result = memberService.signUp(memberDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
