package com.example.nozomi.nozomi_java;

import com.example.nozomi.nozomi_java.mapper.CarMapper;
import com.example.nozomi.nozomi_java.mapper.UserCarMapper;
import com.example.nozomi.nozomi_java.mapper.UserLikeMapper;
import com.example.nozomi.nozomi_java.pojo.UserLike;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class MapperTest {
    /**
     * UserLikeMapper TEST
     */
    @Resource
    UserLikeMapper userLikeMapper;
    @Test
    public void userLikeMapper() {
        UserLike uk = new UserLike();
        uk.setUserId(1);
        uk.setCarId(1);
        UserLike result =  userLikeMapper.checkExist(uk);
//        userLikeMapper.toUnLike(result);
    }

    /**
     * CarMapper TEST
     */
    @Resource
    CarMapper carMapper;
    @Test
    public void carMapper() {
//        System.out.println(carMapper.getSellingCar());
//        System.out.println(carMapper.getCarById(1));
//        System.out.println(carMapper.getCarListByMerchantId(1));

    }

    /**
     * userCarMapper TEST
     */
    @Resource
    UserCarMapper userCarMapper;
    @Test
    public void userCarMapper() {
//        System.out.println(userCarMapper.getCarIdByUserId(1));
//        userCarMapper.changeMerchantStatus(5);
        userCarMapper.cancelMerchantStatus(5);
    }
}
