package com.example.nozomi.nozomi_java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.nozomi.nozomi_java.pojo.Parts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PartsMapper extends BaseMapper<Parts> {
    @Update("alter table g_parts auto_increment = 1")
    void autoIncrement();
}
