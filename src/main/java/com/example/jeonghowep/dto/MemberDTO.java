package com.example.jeonghowep.dto;

import com.example.jeonghowep.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDTO {
    private Long id;
    private String memberemail;
    private String memberid;
    private String memberpassword;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberemail(memberEntity.getMemberemail());
        memberDTO.setMemberid(memberEntity.getMemberid());
        memberDTO.setMemberpassword(memberEntity.getMemberpassword());
        return memberDTO;
    }
}
