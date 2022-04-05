package com.maiorem.member.service;

import com.maiorem.member.domain.Member;
import com.maiorem.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    //회원 가입
    @Transactional
    public Long join(Member member) {
        validateDuplicateMemebr(member); //중복회원 검증
        memberRepository.save(member);
        return member.getMemberId();
    }

    // 중복 시 예외처리
    private void validateDuplicateMemebr(Member member) {
        //Exception
        List<Member> findMembers = memberRepository.findByEmail(member.getEmail());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

    }

    //회원 전체 조회 //읽기전용
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    //회원 단건 조회 //읽기전용
    public Member findOne(Long memberId) {
        return memberRepository.findById(memberId).get();
    }

    // 비밀번호 수정
    @Transactional
    public void update(Long id, String password) {
        Member member = memberRepository.findById(id).get();
        member.changePassword(password);
    }

}
