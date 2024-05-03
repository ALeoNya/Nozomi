package com.example.nozomi.nozomi_java.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("g_parts")
public class Parts {
    @TableId(value = "id", type = IdType.AUTO)  //主键标识
    private Integer id;

    private String carBrand;

    private String carModel;

    private String partsName   ;

    private String inPrice;

    private String outPrice;

    private Integer partsStatus;

    @TableField(fill = FieldFill.INSERT)  //插入时自动填充日期（
    private LocalDate createTime;

    @TableField(fill = FieldFill.UPDATE)  //更新时自动填充日期（
    private LocalDate updateTime;
}
