package com.example.jeonghowep;

import com.example.jeonghowep.dto.MemberDTO;
import com.example.jeonghowep.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

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
    @PostMapping("/loginpage")
    public String loginpage(@ModelAttribute MemberDTO memberDTO, HttpSession session){
        MemberDTO loginResult=memberService.login(memberDTO);
        if(loginResult!=null){
            session.setAttribute("loginid",loginResult.getMemberid());
            return "index";
        }else {
            return "loginpage";
        }

    }
    @GetMapping("/auto")
    public String auto () {
        return "auto";
    }
    @GetMapping("/semiauto")
    public String semiauto () {
        return "semiauto";
    }

    @GetMapping("/index")
    public String index () {
        return "index";
    }
    }


