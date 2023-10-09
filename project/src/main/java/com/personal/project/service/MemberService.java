package com.personal.project.service;

import com.personal.project.dto.MemberDto;
import com.personal.project.entity.Member;
import com.personal.project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    //모든 회원 조회하기

    //카드번호로 회원 조회
    public List<MemberDto> findByCardNum(int cardNum){
        Optional<List<Member>> optionalMember = memberRepository.findByCardNum(cardNum);
        MemberDto memberDto = new MemberDto();
        List<MemberDto> list = new ArrayList<>();
        if(optionalMember.isPresent()){
            List<Member> memberList = optionalMember.get();
            for(Member member : memberList) {
                memberDto.setCardNum(member.getCardNum());
                memberDto.setName(member.getName());
                memberDto.setGender(member.getGender());
                memberDto.setProduct(member.getProduct());
                memberDto.setPhoneNumber(member.getPhoneNumber());
                memberDto.setJoinDate(member.getJoinDate());
                memberDto.setDueDate(member.getDueDate());
                memberDto.setLockerNumber(member.getLockerNumber());
                list.add(memberDto);
            }
        }
        return list;
    }
    //핸드폰 번호로 회원 조회
    public List<MemberDto> findByPhoneNum(String phoneNumber){
        Optional<List<Member>> optionalMember = memberRepository.findByPhoneNumberContaining(phoneNumber);
        MemberDto memberDto = new MemberDto();
        List<MemberDto> list = new ArrayList<>();
        if(optionalMember.isPresent()){
            List<Member> memberList = optionalMember.get();
            for(Member member : memberList) {
                memberDto.setCardNum(member.getCardNum());
                memberDto.setName(member.getName());
                memberDto.setGender(member.getGender());
                memberDto.setProduct(member.getProduct());
                memberDto.setPhoneNumber(member.getPhoneNumber());
                memberDto.setJoinDate(member.getJoinDate());
                memberDto.setDueDate(member.getDueDate());
                memberDto.setLockerNumber(member.getLockerNumber());
                list.add(memberDto);
            }
        }
        return list;
    }

    //이름으로 회원 조회
    public List<MemberDto> findByName(String name){
        Optional<List<Member>> optionalMember = memberRepository.findByName(name);
        MemberDto memberDto = new MemberDto();
        List<MemberDto> list = new ArrayList<>();
        if(optionalMember.isPresent()){
            List<Member> memberList = optionalMember.get();
            for(Member member : memberList) {
                memberDto.setCardNum(member.getCardNum());
                memberDto.setName(member.getName());
                memberDto.setGender(member.getGender());
                memberDto.setProduct(member.getProduct());
                memberDto.setPhoneNumber(member.getPhoneNumber());
                memberDto.setJoinDate(member.getJoinDate());
                memberDto.setDueDate(member.getDueDate());
                memberDto.setLockerNumber(member.getLockerNumber());
                list.add(memberDto);
            }
        }
        return list;
    }
}
