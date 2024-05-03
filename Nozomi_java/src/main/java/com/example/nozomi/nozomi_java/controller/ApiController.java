package com.example.nozomi.nozomi_java.controller;

import com.example.nozomi.nozomi_java.pojo.DTO.ResponseDTO;
import com.example.nozomi.nozomi_java.pojo.UserAuth;
import com.example.nozomi.nozomi_java.response.Code;
import com.example.nozomi.nozomi_java.response.Msg;
import com.example.nozomi.nozomi_java.security.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import static com.example.nozomi.nozomi_java.util.UserUtil.getUserDetailsDTO;

/**
 * 一个Controller对应一个Queue
 */
@CrossOrigin
@RestController
public class ApiController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/user/login")
    public ResponseDTO login(@RequestBody UserAuth user){
        System.out.println(user);
        return loginService.login(user);
    }

    @GetMapping("/test")
    public ResponseDTO Security(){
        System.out.println(getUserDetailsDTO());
        return new ResponseDTO(Code.SUCCESS, Msg.SEL_SUCCESS_MSG,getUserDetailsDTO().getUser().getId());
    }
    
    @PreAuthorize("hasAuthority('/test')")
    @GetMapping("/test2")
    public ResponseDTO Security2(){
//        System.out.println(SecurityContextHolder.getContext());
        return new ResponseDTO(Code.SUCCESS, Msg.SEL_SUCCESS_MSG,SecurityContextHolder.getContext());
    }
}
