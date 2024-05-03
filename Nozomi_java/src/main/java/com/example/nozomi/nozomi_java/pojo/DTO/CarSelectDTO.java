package com.example.nozomi.nozomi_java.pojo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CarSelectDTO {
    private Integer price;
    private Integer sellingPrice;
    private Integer userId;

    @JsonProperty("startTime")
    private LocalDate startTime;
    @JsonProperty("endTime")
    private LocalDate endTime;
}
