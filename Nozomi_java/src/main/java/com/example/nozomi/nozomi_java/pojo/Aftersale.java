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
@TableName("g_aftersale")
public class Aftersale {
    @TableId(value = "id", type = IdType.AUTO)  //主键标识
    private Integer id;

    private String asIssue;

    private String asAnalyse;

    private String asFeedback;

    private Integer status;

    @TableField(fill = FieldFill.INSERT)  //插入时自动填充日期（
    private LocalDate createTime;

    @TableField(fill = FieldFill.UPDATE)  //更新时自动填充日期（
    private LocalDate updateTime;
}
