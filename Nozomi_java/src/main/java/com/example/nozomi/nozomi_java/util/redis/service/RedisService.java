package com.example.nozomi.nozomi_java.util.redis.service;

import com.example.nozomi.nozomi_java.pojo.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public interface RedisService {
    /**
     * 添加缓存
     */
    public boolean cacheValue(String prefix, int key, Object value, long time);
    public boolean cacheValueByName(String prefix, String keyName, Object value, long time);

    public boolean cacheStringValue(String prefix, int k, String value, long time);

    public boolean cacheList(int k, String v, long time);

    public <T> boolean cacheTest(String prefix, int key, ArrayList<T> value, long time);

    /**
     * 判断缓存是否存在
     */
    //泛型
    public boolean containsKey(String prefix, int key);

    /**
     * 获取同前缀的所有的缓存
     * @param prefix
     * @return
     */
    public Map<String, ?> allCache(String prefix);

    /**
     * 获取存在的缓存
     */
    public UserAuth getUserAuth(String key);
    public Resource getResource(Resource resource);
    public Role getRole(Role role);
    public RoleResource getRoleResource(RoleResource roleResource);
    public UserRole getUserRole(UserRole userRole);
    public <T> T getObject(String prefix, int k);
    /**
     * 过期处理
     */
    public boolean expire(String prefix, int k, long timeout, TimeUnit unit);
    public boolean expireByName(String prefix, String k, long timeout, TimeUnit unit);
    /**
     * 删除缓存(考虑并发问题
     */
    public boolean removeByKey(String prefix, String k);
}
