package com.example.jpashop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpashop.domain.Member;
import com.example.jpashop.repository.MemberRepository;
import com.example.jpashop.service.MemberService;

@SpringBootTest
class JpashopApplicationTests {
	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepository;
	@Test
	void 회원가입() {
		Member member = new Member();
		member.setName("kim");

		Member member2 = new Member();
		member2.setName("kim");

		memberService.join(member);
		memberService.join(member2);

		fail("예외가 발생해야 한다");

		
	}

}
