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
@TableName("g_book")
public class Book {
    @TableId(value = "id", type = IdType.AUTO)  //主键标识
    private Integer id;

    private Integer carId;

    private Integer userId;

    private Integer bookTime;

    private Integer bookPlace;

    private Integer bookStatus;

    @TableField(fill = FieldFill.INSERT)
    private LocalDate createTime;
}
