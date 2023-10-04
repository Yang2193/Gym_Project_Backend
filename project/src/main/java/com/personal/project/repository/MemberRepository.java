package com.personal.project.repository;

import com.personal.project.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByCardNum(int cardNum);
    Optional<Member> findByName(String name);
    Optional<Member> findByPhoneNumber(String phoneNumber);
    boolean existsByCardNum(int cardNum);
    boolean existsByPhoneNumber(String phoneNumber);

}
