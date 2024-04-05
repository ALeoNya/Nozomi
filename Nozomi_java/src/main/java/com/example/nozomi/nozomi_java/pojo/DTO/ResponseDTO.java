package com.example.nozomi.nozomi_java.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    private Integer code;
    private String msg;
    private Object data;
}
