package com.example.nozomi.nozomi_java.security.service;


import com.example.nozomi.nozomi_java.pojo.DTO.ResponseDTO;
import com.example.nozomi.nozomi_java.pojo.UserAuth;

public interface LoginService {
    ResponseDTO login(UserAuth user);
}
