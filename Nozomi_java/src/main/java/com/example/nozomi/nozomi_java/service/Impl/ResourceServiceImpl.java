package com.example.nozomi.nozomi_java.service.Impl;

import com.example.nozomi.nozomi_java.mapper.ResourceMapper;
import com.example.nozomi.nozomi_java.pojo.DTO.ResourceDTO;
import com.example.nozomi.nozomi_java.pojo.DTO.ResourceTreeDTO;
import com.example.nozomi.nozomi_java.pojo.DTO.ResponseDTO;
import com.example.nozomi.nozomi_java.pojo.Resource;
import com.example.nozomi.nozomi_java.response.Code;
import com.example.nozomi.nozomi_java.response.Msg;
import com.example.nozomi.nozomi_java.service.ResourceService;
import com.example.nozomi.nozomi_java.util.redis.config.InitRedis;
import com.example.nozomi.nozomi_java.util.redis.service.RedisService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service("ResourceService")
public class ResourceServiceImpl implements ResourceService {
    @javax.annotation.Resource
    private ResourceMapper resourceMapper;
    @javax.annotation.Resource
    private RedisService redisService;

    // 传入哪几个属性？not null 的属性

    /**
     * 属性：resource_name，url，request_method，parent_id，is_anonymous
     * @param resource
     * @return
     */
    @Override
    public ResponseDTO addResource(Resource resource) {
        System.out.println(resource);
        try {
            if(resource == null) {
                return new ResponseDTO(Code.FAILED, Msg.DEL_FAIL_MSG, "插入数据为空");
            }
            System.out.println(resource);

            resourceMapper.autoIncrement();
            resourceMapper.insert(resource);
            return new ResponseDTO(Code.SUCCESS, Msg.ADD_SUCCESS_MSG, resource);
        } catch (RuntimeException e) {
            return new ResponseDTO(Code.FAILED, Msg.DEL_FAIL_MSG, e);
        }
    }

    @Override
    public ResponseDTO delResource(Resource resource) {
//        int key = resource.getId();
        try {
            resourceMapper.deleteById(resource.getId());
            return new ResponseDTO(Code.SUCCESS, Msg.DEL_SUCCESS_MSG, null);
        } catch (RuntimeException e) {
            return new ResponseDTO(Code.FAILED, Msg.DEL_FAIL_MSG, e);
        }
    }

    @Override
    public ResponseDTO selResourceById(Resource resource) {
        int key = resource.getId();
        try {
            if(redisService.containsKey(InitRedis.KEY_RESOURCE_LIST, key)) {
                return new ResponseDTO(Code.SUCCESS, Msg.SEL_SUCCESS_MSG, redisService.getObject(InitRedis.KEY_RESOURCE_LIST, key));
            } else {
                Resource get = resourceMapper.selectById(resource.getId());
                //查到null值缓存到redis设置过期时间为6min
                if(get == null) {
                    redisService.cacheValue(InitRedis.KEY_RESOURCE_LIST, resource.getId(), get, 360);
                    return new ResponseDTO(Code.FAILED, Msg.SEL_FAIL_MSG, "你查询的是一个空值");
                }
                redisService.cacheValue(InitRedis.KEY_RESOURCE_LIST, resource.getId(), get, 3600);
                return new ResponseDTO(Code.SUCCESS, Msg.SEL_SUCCESS_MSG, redisService.getObject(InitRedis.KEY_RESOURCE_LIST, key));
            }

        } catch (RuntimeException e) {
            return new ResponseDTO(Code.FAILED, Msg.SEL_FAIL_MSG, e);
        }
    }

    @Override
    public ResponseDTO allResource() {
        try {
            return new ResponseDTO(Code.SUCCESS, Msg.SEL_SUCCESS_MSG, resourceMapper.selectList(null));
        } catch (RuntimeException e) {
            return new ResponseDTO(Code.FAILED, Msg.SEL_FAIL_MSG, e);
        }
    }

    @Override
    public ResponseDTO allResourceByType() {
        try {
            // 查询“模块”字段获取其id，再用id查询父节点=id的数据，最后返回数据
            // 获取所有模块名
            List<Resource> resourceList = resourceMapper.getFamilyName();
            List<ResourceDTO> resourceDTOList = new ArrayList<>();
            // 模块名称+family数据结构
            for(int i=0; i<resourceList.size(); i++) {
                ResourceDTO resourceDTO = new ResourceDTO();  // 数组对象存储对象的引用而不是值，对象名字相同但引索不同
                // 设置DTO的resource
                resourceDTO.setResource(resourceList.get(i));
                // 设置DTO的family
                resourceDTO.setFamily(resourceMapper.getFamily(resourceList.get(i).getId()));
                // 添加到resourceDTOList
                resourceDTOList.add(resourceDTO);
            }
            return new ResponseDTO(Code.SUCCESS, Msg.SEL_SUCCESS_MSG, resourceDTOList);
        } catch (RuntimeException e) {
            return new ResponseDTO(Code.FAILED, Msg.SEL_FAIL_MSG, e);
        }
    }

    @Override
    public ResponseDTO allResourceByTree() {
        try {
            // 查询“模块”字段获取其id，再用id查询父节点=id的数据，最后返回数据
            // 获取所有模块名
            List<Resource> resourceList = resourceMapper.getFamilyName();
            List<ResourceTreeDTO> resourceTreeDTOList = new ArrayList<>();
            // 模块名称+family数据结构
            for(int i=0; i<resourceList.size(); i++) {
                ResourceTreeDTO resourceTreeDTO = new ResourceTreeDTO();
                // 设置父节点的ID字段
                resourceTreeDTO.setId(resourceList.get(i).getId());
                // 设置resourceName字段
                resourceTreeDTO.setResourceName(resourceList.get(i).getResourceName());
                // 设置url字段
                resourceTreeDTO.setUrl(resourceList.get(i).getUrl());
                resourceTreeDTO.setFamily(resourceMapper.getFamily(resourceList.get(i).getId()));

                resourceTreeDTOList.add(resourceTreeDTO);
            }
            return new ResponseDTO(Code.SUCCESS, Msg.SEL_SUCCESS_MSG, resourceTreeDTOList);
        } catch (RuntimeException e) {
            return new ResponseDTO(Code.FAILED, Msg.SEL_FAIL_MSG, e);
        }
    }

    @Override
    public ResponseDTO updResource(Resource resource) {
//        int key = resource.getId();
        try {
//            redisService.expire(InitRedis.KEY_RESOURCE_LIST, key, 3, TimeUnit.SECONDS);
            System.out.println(resource.getRequestMethod());
            resourceMapper.updateById(resource);
            return new ResponseDTO(Code.SUCCESS, Msg.UPD_SUCCESS_MSG, null);
        } catch (RuntimeException e) {
            return new ResponseDTO(Code.FAILED, Msg.UPD_FAIL_MSG, e);
        }
    }
}