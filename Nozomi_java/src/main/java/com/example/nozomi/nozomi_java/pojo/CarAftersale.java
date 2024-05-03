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
@TableName("g_car_aftersale")
public class CarAftersale {
    @TableId(value = "id", type = IdType.AUTO)  //主键标识
    private Integer id;

    private Integer carId;

    private Integer aftersaleId;
}
