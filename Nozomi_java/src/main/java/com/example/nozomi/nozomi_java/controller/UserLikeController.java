package com.example.nozomi.nozomi_java.controller;

import com.example.nozomi.nozomi_java.mapper.UserLikeMapper;
import com.example.nozomi.nozomi_java.pojo.Car;
import com.example.nozomi.nozomi_java.pojo.Response;
import com.example.nozomi.nozomi_java.pojo.UserLike;
import com.example.nozomi.nozomi_java.response.Code;
import com.example.nozomi.nozomi_java.response.Msg;
import com.example.nozomi.nozomi_java.service.UserLikeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
public class UserLikeController {
    @Resource
    private UserLikeService userLikeService;
    @PostMapping("/userlike")
    public Response addCar(@RequestBody UserLike userLike) {
        return new Response(Code.FAILED, userLikeService.userLikeCar(userLike));
    }
}
