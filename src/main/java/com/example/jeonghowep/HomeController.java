package com.example.jeonghowep;

import com.example.jeonghowep.dto.MemberDTO;
import com.example.jeonghowep.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/jeonghowep")
public class HomeController {

    private final MemberService memberService;

    @GetMapping("/kakaomap")
    public String kakaomap () {
        return "kakaomap";
    }
    @GetMapping("/loginpage")
    public String loginpage(){
        return "loginpage";
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @PostMapping("/register")
    public String registersave(@ModelAttribute MemberDTO memberDTO){
        System.out.println("memberDTO = " + memberDTO);
        memberService.register(memberDTO);
        return "loginpage";
    }


    }


