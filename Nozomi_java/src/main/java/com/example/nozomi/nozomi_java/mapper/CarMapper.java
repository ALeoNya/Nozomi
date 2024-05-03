package com.example.nozomi.nozomi_java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.nozomi.nozomi_java.pojo.Car;
import com.example.nozomi.nozomi_java.pojo.DTO.CarSelectDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.Mapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface CarMapper extends BaseMapper<Car> {
    @Update("alter table `gp_db`.`g_car` auto_increment = 1;")
    void autoIncrement();

    @Update("alter table `gp_db`.`g_car` auto_incremenet = 1")
    boolean update();

    @Update("UPDATE `gp_db`.`g_car` SET `info_id` = LAST_INSERT_ID() where `id` = LAST_INSERT_ID()")
    boolean updateInfoId();

    @Select("select * from `gp_db`.`g_car` where is_delete = 0")
    List<Car> getSellingCar();

    @Select("select * from `gp_db`.`g_car` where id = #{id}")
    Car getCarById(int id);

    // 根据用户id获取对应车辆
    @Select("select * from `gp_db`.`g_car` c " +
            "   left join `gp_db`.`g_user_car` uc " +
            "       on uc.car_id = c.id where user_id = #{userId}")
    List<Car> getCarListByUserId(int userid);

    // 根据商户id获取寄售车辆
    @Select("select * from `gp_db`.`g_car` c " +
            "   left join `gp_db`.`g_user_car` uc " +
            "       on uc.car_id = c.id where merchant_id = #{merchantId}")
    List<Car> getCarListByMerchantId(int merchantId);

    @Select("SELECT LAST_INSERT_ID()")
    int lastInsertId();

    // IS NULL是admin使用的
    @Select("SELECT c.*   \n" +
            "FROM `gp_db`.`g_car` c   \n" +
            "LEFT JOIN `gp_db`.`g_user_car` uc ON uc.car_id = c.id    \n" +
            "WHERE (  \n" +
            "    c.price = #{price}   \n" +
            "    OR c.selling_price = #{sellingPrice}   \n" +
            "    OR (c.create_time BETWEEN #{startTime} AND #{endTime})  \n" +
            ")  \n" +
            "AND (uc.user_id = #{userId} OR uc.user_id IS NULL)")
    List<Car> getCarByCondition(CarSelectDTO dto);
}
