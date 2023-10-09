package com.personal.project.repository;

import com.personal.project.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<List<Member>> findByCardNum(int cardNum);
    Optional<List<Member>> findByName(String name);
    Optional<List<Member>> findByPhoneNumberContaining(String phoneNumber);
    boolean existsByCardNum(int cardNum);
    boolean existsByPhoneNumber(String phoneNumber);

}
