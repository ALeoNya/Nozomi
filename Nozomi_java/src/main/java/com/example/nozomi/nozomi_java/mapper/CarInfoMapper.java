package com.example.nozomi.nozomi_java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.nozomi.nozomi_java.pojo.CarInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CarInfoMapper extends BaseMapper<CarInfo> {
    @Update("alter table `gp_db`.`g_car_info` auto_increment = 1")
    void autoIncrement();

    @Select("SELECT LAST_INSERT_ID()")
    int lastInsertId();
}
