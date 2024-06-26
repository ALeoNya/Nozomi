package com.example.nozomi.nozomi_java.pojo.DTO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.nozomi.nozomi_java.pojo.Resource;
import lombok.Data;

import java.util.List;

@Data
public class ResourceTreeDTO {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String resourceName;
    private String url;
    private List<Resource> family;
}