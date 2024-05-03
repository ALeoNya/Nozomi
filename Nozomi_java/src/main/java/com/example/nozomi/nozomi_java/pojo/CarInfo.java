package com.example.nozomi.nozomi_java.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder  //构造器,提供一个构造器方法
@Data  //提供类的get、set、equals、hashCode、canEqual、toString方法
@NoArgsConstructor  //生成无参构造方法
@AllArgsConstructor  //生成全参数的构造器
@TableName("g_car_info")
public class CarInfo {
    @TableId(value = "id", type = IdType.AUTO)  //主键标识
    private Integer id;

    private String licensePic;

    private String carCode;

    private String carBrand;

    private String carSeries;

    private String carModel;

    private boolean carGear;

    private String carDisplacement;

    private String carColor;

    private int registrationTimes;

    private int insureTimes;

    private int kilometre;

    private int sellingPrice;

    private LocalDateTime firstRegistration;

    @TableField(fill = FieldFill.INSERT)  //插入时自动填充日期（
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)  //更新时自动填充日期（
    private LocalDateTime updateTime;
}
