package com.personal.project.controller;

import com.personal.project.dto.MemberDto;
import com.personal.project.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/findByCardNum")
    public ResponseEntity<List<MemberDto>> findByCardNum(@RequestBody MemberDto memberDto){
        List<MemberDto> list = memberService.findByCardNum(memberDto.getCardNum());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/findByPhoneNum")
    public ResponseEntity<List<MemberDto>> findByPhoneNum(@RequestBody MemberDto memberDto){
        List<MemberDto> list = memberService.findByPhoneNum(memberDto.getPhoneNumber());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/findByName")
    public ResponseEntity<List<MemberDto>> findByName(@RequestBody MemberDto memberDto){
        List<MemberDto> list = memberService.findByName(memberDto.getName());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
