package com.example.nozomi.nozomi_java.service.Impl;

import com.example.nozomi.nozomi_java.mapper.RoleMapper;
import com.example.nozomi.nozomi_java.pojo.DTO.ResponseDTO;
import com.example.nozomi.nozomi_java.pojo.Role;
import com.example.nozomi.nozomi_java.response.Code;
import com.example.nozomi.nozomi_java.response.Msg;
import com.example.nozomi.nozomi_java.service.RoleService;
import com.example.nozomi.nozomi_java.util.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("RoleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RedisService redisService;
    @Override
    public ResponseDTO addRole(Role role) {
        int key = role.getId();
        try {
            if(role.getRoleName() == null) {
                return new ResponseDTO(Code.FAILED, Msg.ADD_FAIL_MSG, "插入数据为空");
            }
            roleMapper.autoIncrement();
            roleMapper.insert(role);
        } catch (RuntimeException e) {
            return new ResponseDTO(Code.FAILED, Msg.ADD_FAIL_MSG, e);
        }
        return new ResponseDTO(Code.SUCCESS, Msg.ADD_SUCCESS_MSG, role);
    }

    @Override
    public ResponseDTO delRole(Role role) {
        int key = role.getId();
        try {
            roleMapper.deleteById(key);
            return new ResponseDTO(Code.SUCCESS, Msg.DEL_SUCCESS_MSG, null);
        } catch (RuntimeException e) {
            return new ResponseDTO(Code.FAILED, Msg.DEL_FAIL_MSG, e);
        }
    }

    @Override
    public ResponseDTO allRole() {
        try {
            return new ResponseDTO(Code.SUCCESS, Msg.SEL_SUCCESS_MSG, roleMapper.selectList(null));
        } catch (RuntimeException e) {
            return new ResponseDTO(Code.FAILED, Msg.SEL_FAIL_MSG, e);
        }
    }

//    @Override
//    public ResponseDTO selRoleById(Role role) {
//        int key = role.getId();
//        try {
//            if(redisService.containsKey(InitRedis.KEY_ROLE_LIST, key)) {
//                return new ResponseDTO(Code.SUCCESS, Msg.SEL_SUCCESS_MSG, redisService.getRole(role));
//            } else {
//                Role get = roleMapper.selectById(key);
//                //查到null值缓存到redis设置过期时间为6min
//                if(get == null) {
//                    redisService.cacheValue(InitRedis.KEY_ROLE_LIST, key, get, 360);
//                    return new ResponseDTO(Code.FAILED, Msg.SEL_FAIL_MSG, "你查询的是一个空值");
//                }
//                redisService.cacheValue(InitRedis.KEY_ROLE_LIST, key, get, 3600);
//                return new ResponseDTO(Code.SUCCESS, Msg.SEL_SUCCESS_MSG, redisService.getRole(role));
//            }
//
//        } catch (RuntimeException e) {
//            return new ResponseDTO(Code.FAILED, Msg.SEL_FAIL_MSG, e);
//        }
//    }

    /**
     * 登录判断权限
     * @param role
     * @return
     */
    @Override
    public ResponseDTO selRoleById(Role role) {
        int key = role.getId();
        try {
            if(role.getId() == null) {
                return new ResponseDTO(Code.SUCCESS, Msg.SEL_SUCCESS_MSG, "插入数值不能为空");
            } else {
                Role get = roleMapper.selectById(role.getId());
                //查到null值缓存到redis设置过期时间为6min
                if(get == null) {
                    return new ResponseDTO(Code.FAILED, Msg.SEL_FAIL_MSG, "你查询的是一个空值");
                }
                return new ResponseDTO(Code.SUCCESS, Msg.SEL_SUCCESS_MSG, get);
            }

        } catch (RuntimeException e) {
            return new ResponseDTO(Code.FAILED, Msg.SEL_FAIL_MSG, e);
        }
    }

    @Override
    public ResponseDTO updRole(Role role) {
        int key = role.getId();
        try {
            roleMapper.updateById(role);
            return new ResponseDTO(Code.SUCCESS, Msg.UPD_SUCCESS_MSG, null);
        } catch (RuntimeException e) {
            return new ResponseDTO(Code.FAILED, Msg.UPD_FAIL_MSG, e);
        }
    }
}
