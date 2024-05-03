package com.example.nozomi.nozomi_java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.nozomi.nozomi_java.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
    @Update("alter table `gp_db`.`g_book` auto_increment = 1")
    void autoIncrement();
    @Select("SELECT * FROM g_book WHERE user_id = #{userId}")
    List<Book> SelectReservationByUserId(int userId);
}
