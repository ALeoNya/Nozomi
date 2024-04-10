package com.example.nozomi.nozomi_java.controller;

import com.example.nozomi.nozomi_java.pojo.Response;
import com.example.nozomi.nozomi_java.pojo.UserLike;
import com.example.nozomi.nozomi_java.response.Code;
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
    @PostMapping("/userLike")
    public Response userLike(@RequestBody UserLike userLike) {
        return new Response(Code.FAILED, userLikeService.userLikeCar(userLike));
    }
}
