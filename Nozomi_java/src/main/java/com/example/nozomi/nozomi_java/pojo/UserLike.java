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
@TableName("g_user_like")
public class UserLike {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer carId;

    private boolean liked;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
