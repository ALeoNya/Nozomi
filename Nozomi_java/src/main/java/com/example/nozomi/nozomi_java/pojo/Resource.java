package com.example.nozomi.nozomi_java.pojo;


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("g_resource")
public class Resource {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String resourceName;

    private String url;

    private String requestMethod;

    private Integer parentId;

    private Integer isAnonymous;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
}
