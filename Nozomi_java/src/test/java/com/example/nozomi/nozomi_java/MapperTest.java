package com.example.nozomi.nozomi_java;

import com.example.nozomi.nozomi_java.mapper.*;
import com.example.nozomi.nozomi_java.pojo.CarInfo;
import com.example.nozomi.nozomi_java.pojo.DTO.CarSelectDTO;
import com.example.nozomi.nozomi_java.pojo.UserLike;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDate;

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
        CarSelectDTO dto = new CarSelectDTO();
//        dto.setEndTime(LocalDate.of(2024, 1, 1));
//        dto.setStartTime(LocalDate.of(2023, 1, 1));
        dto.setUserId(1);
        System.out.println(carMapper.getCarByCondition(dto));
    }

    /**
     *  CarInfoMapper TEST
     */
    @Resource
    CarInfoMapper carInfoMapper;
    @Test
    public void carInfoMapper() {
        CarInfo carInfo = new CarInfo();
        carInfo.setId(2);
        carInfo.setCarBrand("阿斯顿马丁");
        carInfoMapper.updateById(carInfo);
//        carInfoMapper.autoIncrement();
//        carInfoMapper.insert(carInfo);
    }

    /**
     * userCarMapper TEST
     */
    @Resource
    UserCarMapper userCarMapper;
    @Test
    public void userCarMapper() {
        userCarMapper.cancelMerchantStatus(5);
    }

    @Resource
    RoleResourceMapper roleResourceMapper;
    @Test
    public void roleResourceMapper() {
        System.out.println(roleResourceMapper.listPermsByUserId(1));
    }
}
