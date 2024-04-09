package com.example.nozomi.nozomi_java;

import com.example.nozomi.nozomi_java.mapper.UserLikeMapper;
import com.example.nozomi.nozomi_java.pojo.UserLike;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class MapperTest {
    @Resource
    UserLikeMapper userLikeMapper;
    @Test
    public void checkExist() {
        UserLike uk = new UserLike();
        uk.setUserId(1);
        uk.setCarId(0);
        System.out.println(userLikeMapper.checkExist(uk));
    }
}
