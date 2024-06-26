package com.example.nozomi.nozomi_java.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("g_user_car")
public class UserCar {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer carId;

    private Integer userId;

    private Integer merchantId;

    private boolean merchantStatus;

    private boolean saleType;
}
