package com.example.nozomi.nozomi_java.util.redis.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.nozomi.nozomi_java.mapper.*;
import com.example.nozomi.nozomi_java.pojo.Car;
import com.example.nozomi.nozomi_java.util.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Configuration
public class InitRedis {
    @Resource
    private CarMapper carMapper;
    @Resource
    private UserAuthMapper userAuthMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RoleResourceMapper roleResourceMapper;
    @Resource
    private ResourceMapper resourceMapper;
    @Resource
    private RedisService redisService;

    public static final String KEY_USERINFO_LIST = "DB:k_user_Info:userInfo";
    public static final String KEY_USERAUTH_LIST = "DB:k_user_auth:userAuth";

    public static final String KEY_USERROLE_LIST = "DB:k_user_role:userRole";
    public static final String KEY_USERROLE_I_LIST = "DB:k_user_role_I:userRole";


    public static final String KEY_ROLE_LIST = "DB:k_role:role";
    public static final String KEY_ROLERESOURCE_LIST = "DB:k_role_resource:roleResource";
    public static final String KEY_RESOURCE_LIST = "DB:k_resource:resource";
    public static final String KEY_ARTICLE_LIST = "DB:k_article:article:not_delete";
    public static final String KEY_ARTICLE_LIST_DELETE = "DB:k_article:recycle:is_delete";

    @PostConstruct  //springboot初始化后自动执行
    public void initRedis() {
        /**
         *初始化 Redis(用户认证授权模块)
         */
//        ArrayList<UserAuth> list = (ArrayList<UserAuth>) userAuthMapper.selectList(null);
//        for(int i = 0; i<list.size(); i++) {
//            int time = 36000000;
//            redisService.cacheValue(list.get(i).getId(), list.get(i), time);
//        }
        userInfoMapper.selectList(null)
                .stream()
                .forEach(userInfo -> redisService.cacheValue(KEY_USERINFO_LIST, userInfo.getId(), userInfo, 36000));
        userAuthMapper.selectList(null)
                .stream()
                .forEach(userAuth -> redisService.cacheValue(KEY_USERAUTH_LIST, userAuth.getId(), userAuth, 36000));
        userRoleMapper.selectList(null)
                .stream()
                .forEach(userRole -> redisService.cacheValue(KEY_USERROLE_LIST, userRole.getId(), userRole, 36000));
        roleMapper.selectList(null)
                .stream()
                .forEach(role-> redisService.cacheValue(KEY_ROLE_LIST, role.getId(), role, 36000));
        roleResourceMapper.selectList(null)
                .stream()
                .forEach(roleResource -> redisService.cacheValue(KEY_ROLERESOURCE_LIST, roleResource.getId(), roleResource, 36000));
        resourceMapper.selectList(null)
                .stream()
                .forEach(resource -> redisService.cacheValue(KEY_RESOURCE_LIST, resource.getId(), resource, 36000));

        // 文章列表
//        QueryWrapper<Car> wrapper = new QueryWrapper<>();
//        wrapper.eq("is_delete",0);
//        carMapper.selectList(wrapper)
//                .stream()
//                .forEach(articles -> redisService.cacheValue(KEY_ARTICLE_LIST, articles.getId(), articles, 36000));


        // 文章回收站列表
        QueryWrapper<Car> articleDeleteWrapper = new QueryWrapper<>();
        articleDeleteWrapper.eq("is_delete",1);
        carMapper.selectList(articleDeleteWrapper)
                .stream()
                .forEach(article -> redisService.cacheValue(KEY_ARTICLE_LIST_DELETE, article.getId(), article, 36000));
    }
}
