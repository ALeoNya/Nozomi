package com.example.nozomi.nozomi_java.controller;

import com.example.nozomi.nozomi_java.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;


}
