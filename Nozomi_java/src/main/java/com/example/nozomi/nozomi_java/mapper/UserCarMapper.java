package com.example.nozomi.nozomi_java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.nozomi.nozomi_java.pojo.Car;
import com.example.nozomi.nozomi_java.pojo.UserCar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserCarMapper extends BaseMapper<UserCar> {
    // TODO 根据用户id获取其拥有的商品
    @Select("select * from `gp_db`.`g_user_car` where user_id = #{userId}")
    List<Integer> getCarIdByUserId(int userId);

}
