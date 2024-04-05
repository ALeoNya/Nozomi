package com.example.nozomi.nozomi_java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.nozomi.nozomi_java.pojo.Car;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
public interface CarMapper extends BaseMapper<Car> {

}
