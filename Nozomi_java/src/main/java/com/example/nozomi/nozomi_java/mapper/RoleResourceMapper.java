package com.example.nozomi.nozomi_java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.nozomi.nozomi_java.pojo.RoleResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface RoleResourceMapper extends BaseMapper<RoleResource> {
    /**
     * 通过角色ID获取角色对应的权限ID
     * @param user_id
     * @return
     */
//    @Select("SELECT resource_id FROM kotori.k_role_resource WHERE role_id = #{role_id}")
//    List<String> listPermsByUserId(int role_id);

    @Select("SELECT url " +
            " FROM g_user_role ur " +
            "\t\tLEFT JOIN g_role r ON ur.role_id = r.id\n" +
            "        LEFT JOIN g_role_resource rr ON ur.role_id = rr.role_id\n" +
            "        LEFT JOIN g_resource res ON rr.resource_id = res.id\n" +
            "WHERE user_id= #{user_id}")
    List<String> listPermsByUserId(int user_id);

    @Update("alter table `gp_db`.`g_role_resource` auto_increment = 1")
    void autoIncrement();

    @Select("SELECT resource_id FROM `gp_db`.`g_role_resource` WHERE role_id = #{roleId}")
    List<Integer> getResourceByRoleId(RoleResource resource);
}
