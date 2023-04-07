package com.example.jeonghowep.service;

import com.example.jeonghowep.dto.MemberDTO;
import com.example.jeonghowep.entity.MemberEntity;
import com.example.jeonghowep.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public void register(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }
}
