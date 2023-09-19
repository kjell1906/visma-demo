package com.example.vismademo.service;

import com.example.vismademo.entities.Member;
import com.example.vismademo.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member findMemberById(Integer id) {

        Optional<Member> member = memberRepository.findById(id);
        if(member.isPresent()) {
            return member.get();
        }
        return null;
    }
}
