package com.example.nozomi.nozomi_java.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("g_aftersale_parts")
public class AftersaleParts {
    @TableId(value = "id", type = IdType.AUTO)  //主键标识
    private Integer id;

    private Integer partId;

    private Integer aftersaleId;

    private Integer useNumber;
}
