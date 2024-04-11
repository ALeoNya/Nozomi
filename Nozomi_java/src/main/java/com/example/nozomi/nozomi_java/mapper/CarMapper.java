package com.example.nozomi.nozomi_java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.nozomi.nozomi_java.pojo.Car;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper
public interface CarMapper extends BaseMapper<Car> {
    @Update("alter table `gp_db`.`g_car` auto_incremenet = 1")
    void autoIncrement();

    @Update("alter table `gp_db`.`g_car` auto_incremenet = 1")
    boolean update();

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
}
