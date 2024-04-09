package com.example.nozomi.nozomi_java.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder  //构造器,提供一个构造器方法
@Data  //提供类的get、set、equals、hashCode、canEqual、toString方法
@NoArgsConstructor  //生成无参构造方法
@AllArgsConstructor  //生成全参数的构造器
@TableName("g_car")
public class Car {
    @TableId(value = "id", type = IdType.AUTO)  //主键标识
    private Integer id;

    private Integer infoId;

    private Integer carCover;

    private String carTitle;

    private String carAbstract;

    private String carContent;

    private String price;

    private String sellingPrice;

    private Integer isTop;

    private Integer isFeatured;

    private Integer isDelete;

    private Integer sellingType;

    @TableField(fill = FieldFill.INSERT)  //插入时自动填充日期（
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)  //更新时自动填充日期（
    private LocalDateTime updateTime;
}
