package com.likelion.multipartfile_assignment.iamge.member.domain.repository;


import com.likelion.multipartfile_assignment.iamge.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}