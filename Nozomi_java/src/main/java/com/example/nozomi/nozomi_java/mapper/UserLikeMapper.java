package com.example.nozomi.nozomi_java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.nozomi.nozomi_java.pojo.UserLike;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserLikeMapper extends BaseMapper<UserLike> {
    // 根据userId和carId判断点赞关系是否存在
    @Select(" select * from `gp_db`.`g_user_like` where car_id = #{carId} and user_id = #{userId} ")
    UserLike checkExist(UserLike userLike);

    @Update("UPDATE `gp_db`.`g_user_like` SET `liked` = '0' WHERE id = #{id}")
    boolean toUnLike(UserLike userLike);

    @Update("UPDATE `gp_db`.`g_user_like` SET `liked` = '1' WHERE id = #{id}")
    boolean toLike(UserLike userLike);
}
