package com.example.nozomi.nozomi_java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.nozomi.nozomi_java.pojo.AftersaleParts;
import com.example.nozomi.nozomi_java.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AftersalePartsMapper extends BaseMapper<AftersaleParts> {
    @Update("alter table g_aftersale_parts auto_increment = 1")
    void autoIncrement();
}
