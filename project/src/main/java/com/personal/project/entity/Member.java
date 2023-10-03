package com.personal.project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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


}
