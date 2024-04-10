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
            else {
                if (result.isLiked()) {
                    userLikeMapper.toUnLike(result);
                    return "更新状态为取消点赞";
                }
                else {
                    userLikeMapper.toLike(  result);
                    return "更新状态为已点赞";
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e);
            return "出现未知错误";
        }
    }
}
