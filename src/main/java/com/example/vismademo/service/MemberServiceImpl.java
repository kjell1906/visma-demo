package com.example.vismademo.service;

import com.example.vismademo.entities.Member;
import com.example.vismademo.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Using service to make the service loose coupled.
 * This gives us the option to use Service Layer in other services or controllers with just calling the service method to
 * get data from logic. We also hold the logic in methods in service class and have achieved code reuse and only one place to update the code.
 */
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
