package com.personal.project.dto;

import com.personal.project.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class MemberDto {
    private int cardNum; // 카드번호
    private String name; // 이름
    private String gender; // 성별
    private String phoneNumber; // 전화번호
    private String product; // 상품명
    private LocalDateTime joinDate; // 가입일자
    private LocalDateTime dueDate; // 만료일자

    public Member toMember(){
        return Member.builder()
                .cardNum(cardNum)
                .name(name)
                .gender(gender)
                .phoneNumber(phoneNumber)
                .product(product)
                .joinDate(joinDate)
                .dueDate(dueDate)
                .build();
    }

}




