package com.example.nozomi.nozomi_java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.nozomi.nozomi_java.pojo.UserAuth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserAuthMapper extends BaseMapper<UserAuth> {
    @Update("alter table `gp_db`.`g_user_auth` auto_increment = 1")
    void autoIncrement();
}
