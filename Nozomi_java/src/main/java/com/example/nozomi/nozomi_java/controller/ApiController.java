package com.example.nozomi.nozomi_java.controller;

import com.example.nozomi.nozomi_java.pojo.DTO.ResponseDTO;
import com.example.nozomi.nozomi_java.pojo.UserAuth;
import com.example.nozomi.nozomi_java.security.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
}
