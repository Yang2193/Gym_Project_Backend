package com.personal.project.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;
    @Column(unique = true, length = 20, nullable = false)
    private int cardNum;
    @Column(length = 20)
    private String name;
    @Column
    private String gender;
    @Column
    private String phoneNumber;
    @Column
    private String product;
    @Column
    private LocalDateTime joinDate;
    @Column
    private LocalDateTime dueDate;

    @Builder
    public Member(int cardNum, String name, String gender, String phoneNumber, String product, LocalDateTime joinDate, LocalDateTime dueDate){
        this.cardNum = cardNum;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.product = product;
        this.joinDate = joinDate;
        this.dueDate = dueDate;
    }



}
