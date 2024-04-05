package com.example.nozomi.nozomi_java.service.Impl;

import com.example.nozomi.nozomi_java.mapper.RoleResourceMapper;
import com.example.nozomi.nozomi_java.pojo.DTO.ResponseDTO;
import com.example.nozomi.nozomi_java.pojo.RoleResource;
import com.example.nozomi.nozomi_java.response.Code;
import com.example.nozomi.nozomi_java.response.Msg;
import com.example.nozomi.nozomi_java.service.RoleResourceService;
import com.example.nozomi.nozomi_java.util.redis.config.InitRedis;
import com.example.nozomi.nozomi_java.util.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service("RoleResourceService")
public class RoleResourceServiceImpl implements RoleResourceService {
    @Autowired
    private RoleResourceMapper roleResourceMapper;
    @Autowired
    private RedisService redisService;
    /**
     * 为某个角色添加一个权限
     * @param roleResource
     * @return
     */
    @Override
    public ResponseDTO addRoleResource(RoleResource roleResource) {
        int key = roleResource.getId();
        try {
            roleResourceMapper.insert(roleResource);
            redisService.cacheValue(InitRedis.KEY_ROLERESOURCE_LIST, key, roleResource, 36000);
            if(redisService.getRoleResource(roleResource) == null) {
                return new ResponseDTO(Code.FAILED, Msg.DEL_FAIL_MSG, "插入数据为空");
            }
            return new ResponseDTO(Code.SUCCESS, Msg.DEL_SUCCESS_MSG, redisService.cacheValue(InitRedis.KEY_ROLERESOURCE_LIST, key, roleResource, 36000));
        } catch (RuntimeException e) {
            return new ResponseDTO(Code.FAILED, Msg.DEL_FAIL_MSG, e);
        }
    }

    /**
     * 删除角色与权限的关系
     * @param roleResource
     * @return
     */
    @Override
    public ResponseDTO delRoleResource(RoleResource roleResource) {
        int key = roleResource.getId();
        try {
            redisService.expire(InitRedis.KEY_ROLERESOURCE_LIST, key, 3, TimeUnit.SECONDS);
            roleResourceMapper.deleteById(key);
        } catch(RuntimeException e) {
            return new ResponseDTO(Code.FAILED, Msg.DEL_FAIL_MSG, e);
        }
        return new ResponseDTO(Code.SUCCESS, Msg.DEL_SUCCESS_MSG, redisService.getRoleResource(roleResource));
    }

    @Override
    public ResponseDTO selRoleResourceById(RoleResource roleResource) {
        int key = roleResource.getId();
        try {
            if(redisService.containsKey(InitRedis.KEY_ROLERESOURCE_LIST, key)) {
                return new ResponseDTO(Code.SUCCESS, Msg.SEL_SUCCESS_MSG, redisService.getRoleResource(roleResource));
            } else {
                RoleResource get = roleResourceMapper.selectById(key);
                //查到null值缓存到redis设置过期时间为6min
                if(get == null) {
                    redisService.cacheValue(InitRedis.KEY_ROLERESOURCE_LIST, key, get, 360);
                    return new ResponseDTO(Code.FAILED, Msg.SEL_FAIL_MSG, "你查询的是一个空值");
                }
                redisService.cacheValue(InitRedis.KEY_ROLERESOURCE_LIST, key, get, 3600);
                return new ResponseDTO(Code.SUCCESS, Msg.SEL_SUCCESS_MSG, redisService.getRoleResource(roleResource));
            }

        } catch (RuntimeException e) {
            return new ResponseDTO(Code.FAILED, Msg.SEL_FAIL_MSG, e);
        }
    }

    @Override
    public ResponseDTO selAllResourceIdById(RoleResource roleResource) {
        try {
            return new ResponseDTO(Code.SUCCESS, Msg.SEL_SUCCESS_MSG, roleResourceMapper.getResourceByRoleId(roleResource));
        } catch (RuntimeException e) {
            return new ResponseDTO(Code.FAILED, Msg.SEL_FAIL_MSG, e);
        }
    }

    @Override
    public ResponseDTO allRoleResource(RoleResource roleResource) {
        try {
            return new ResponseDTO(Code.SUCCESS, Msg.SEL_SUCCESS_MSG, redisService.allCache(InitRedis.KEY_ROLERESOURCE_LIST));
        } catch (RuntimeException e) {
            return new ResponseDTO(Code.FAILED, Msg.SEL_FAIL_MSG, e);
        }
    }

    @Override
    public ResponseDTO updRoleResource(RoleResource roleResource) {
        int key = roleResource.getId();
        try {
            redisService.expire(InitRedis.KEY_ROLERESOURCE_LIST, key, 3, TimeUnit.SECONDS);
            roleResourceMapper.updateById(roleResource);
            return new ResponseDTO(Code.SUCCESS, Msg.UPD_SUCCESS_MSG, redisService.getRoleResource(roleResource));
        } catch (RuntimeException e) {
            return new ResponseDTO(Code.FAILED, Msg.UPD_FAIL_MSG, e);
        }
    }
}
