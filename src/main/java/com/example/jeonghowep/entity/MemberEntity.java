package com.example.jeonghowep.entity;

import javax.persistence.*;

import com.example.jeonghowep.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
@Table(name="member_table")
public class MemberEntity {
    @Id //pk지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private Long id;

    @Column(unique = true)
    private String memberemail;
    @Column
    private String memberpassword;
    @Column
    private String memberid;
    public static MemberEntity toMemberEntity(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberemail(memberEntity.getMemberemail());
        memberEntity.setMemberpassword(memberDTO.getMemberpassword());
        memberEntity.setMemberid(memberDTO.getMemberid());
        return memberEntity;
    }
}
