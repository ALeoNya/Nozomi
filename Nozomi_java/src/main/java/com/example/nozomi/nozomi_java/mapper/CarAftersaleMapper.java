package com.example.nozomi.nozomi_java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.nozomi.nozomi_java.pojo.Book;
import com.example.nozomi.nozomi_java.pojo.CarAftersale;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CarAftersaleMapper extends BaseMapper<CarAftersale> {
    @Update("alter table g_car_aftersale auto_increment = 1")
    void autoIncrement();

}
