package com.example.vismademo.service;

import com.example.vismademo.entities.Member;
import com.example.vismademo.repositories.MemberRepository;

public interface MemberService {

    Member findMemberById(Integer id);


}
