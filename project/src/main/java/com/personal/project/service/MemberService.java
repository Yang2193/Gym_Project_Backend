package com.personal.project.service;

import com.personal.project.dto.MemberDto;
import com.personal.project.entity.Member;
import com.personal.project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public boolean signUp(MemberDto dto){
        if(memberRepository.existsByPhoneNumber(dto.getPhoneNumber())){
            throw new RuntimeException("이미 가입되어 있는 전화번호입니다.");
        }
        Member member = dto.toMember();
        try {
            memberRepository.save(member);
            return true;
        } catch(Exception e){
            log.error("회원 가입 중 오류 발생", e);
            return false;
        }
    }
}
