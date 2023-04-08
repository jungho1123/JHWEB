package com.example.jeonghowep.service;

import com.example.jeonghowep.dto.MemberDTO;
import com.example.jeonghowep.entity.MemberEntity;
import com.example.jeonghowep.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public void register(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        //회원이 입력한 id로 db에서 조회
        Optional<MemberEntity> byMemberid = memberRepository.findByMemberid(memberDTO.getMemberid());
        if(byMemberid.isPresent()){
            MemberEntity memberEntity = byMemberid.get();
            if(memberEntity.getMemberpassword().equals(memberDTO.getMemberpassword())){
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            }else{
            return null;
            }

        }else{
            return null;
        }

}
}
