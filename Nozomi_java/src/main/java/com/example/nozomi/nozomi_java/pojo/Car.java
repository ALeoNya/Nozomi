package com.example.nozomi.nozomi_java.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("g_car")
@NoArgsConstructor  //生成无参构造方法
@AllArgsConstructor  //生成全参数的构造器
public class Car {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer infoId;
    private String carCover;
    private String carTitle;
    private String carAbstract;
    private String carContent;
    private Integer price;
    private Integer sellingPrice;
    private Integer isTop;
    private Integer isFeatured;
    private Integer isDelete;
    private String sellingtype;
    private Integer createTime;
    private Integer updateTime;
}
