package com.example.vismademo.repositories;

import com.example.vismademo.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
