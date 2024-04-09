package com.example.nozomi.nozomi_java.service.Impl;

import com.example.nozomi.nozomi_java.mapper.UserLikeMapper;
import com.example.nozomi.nozomi_java.pojo.UserLike;
import com.example.nozomi.nozomi_java.service.UserLikeService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("LikeUserService")
public class UserLikeServiceImpl implements UserLikeService {
    @Resource
    private UserLikeMapper userLikeMapper;
    @Override
    // 点赞车辆
    public String userLikeCar(UserLike userLike) {
        try {
            // 判断点赞关系是否存在
            //不存在，新建
            UserLike result = userLikeMapper.checkExist(userLike);
            if(result == null) {
                userLikeMapper.insert(userLike);
                return "新建已点赞关系";
            }
            // 存在但是取消点赞状态
            else if (result != null && result.isLiked() == false) {
                userLikeMapper.toLike(userLike);
                return "更新状态为已点赞";
            }
            // 存在但是已点赞状态
            else if (result != null && result.isLiked() == true) {
                userLikeMapper.toUnLike(userLike);
                return "更新状态为取消点赞";
            }
        } catch (RuntimeException e) {
            System.out.println(e);
            return "出现未知错误";
        }
        return "hii";
    }



}
