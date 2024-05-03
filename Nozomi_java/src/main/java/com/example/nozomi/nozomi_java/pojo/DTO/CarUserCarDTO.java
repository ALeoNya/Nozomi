package com.example.nozomi.nozomi_java.pojo.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CarUserCarDTO {
    // CarUser
    private Integer id;

    private Integer carId;

    private Integer userId;

    private Integer merchantId;

    private boolean merchantStatus;

    private boolean saleType;

    // Car
    private Integer infoId;

    private String carCover;

    private String carTitle;

    private String carAbstract;

    private String carContent;

    private String price;

    private String sellingPrice;

    private Integer isTop;

    private Integer isFeatured;

    private Integer isDelete;

    private Integer sellingType;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
