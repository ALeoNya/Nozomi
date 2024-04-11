package com.example.nozomi.nozomi_java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.nozomi.nozomi_java.pojo.UserCar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserCarMapper extends BaseMapper<UserCar> {
    // 根据用户id获取其拥有的商品
    @Select("select * from `gp_db`.`g_user_car` where user_id = #{userId}")
    List<Integer> getCarIdByUserId(int userId);

    // 个人对指定商户发起寄售请求(添加指定商家的id
    @Update("update `gp_db`.`g_user_car` " +
            "   set merchant_id = #{merchantId}, merchant_status = 1, sale_type = 1 " +
            "where car_id = #{carId}")
    boolean changeSaleTypeByCarId(UserCar userCar);

    // 商户通过寄售审核，修改merchant_status
    @Update("update  `gp_db`.`g_user_car` " +
            "   set merchant_status = 1 , sale_type = 1 " +
            "where id = #{carId}")
    void changeMerchantStatus(int carId);

    // 用户取消寄售协议
//    @Update("update  `gp_db`.`g_user_car` " +
//            "   set merchant_status = 0 , sale_type = 1 , merchant_id = 0" +
//            "where id = #{carId}")
//    void cancelMerchantStatus(int carId);
}
