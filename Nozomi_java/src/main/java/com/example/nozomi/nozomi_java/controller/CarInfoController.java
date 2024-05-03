package com.example.nozomi.nozomi_java.controller;

import com.example.nozomi.nozomi_java.pojo.CarInfo;
import com.example.nozomi.nozomi_java.pojo.DTO.CarUserCarDTO;
import com.example.nozomi.nozomi_java.pojo.DTO.ResponseDTO;
import com.example.nozomi.nozomi_java.pojo.Response;
import com.example.nozomi.nozomi_java.response.Code;
import com.example.nozomi.nozomi_java.response.Msg;
import com.example.nozomi.nozomi_java.service.CarInfoService;
import com.example.nozomi.nozomi_java.service.CarService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class CarInfoController {
    @Resource
    private CarInfoService carInfoService;

    @PostMapping("/carInfo/getInfoById/{id}")
    //添加车辆信息
    public ResponseDTO addCar(@PathVariable int id) {
        return new ResponseDTO(Code.SUCCESS, Msg.SEL_SUCCESS_MSG,carInfoService.getCarInfoById(id));
    }

    @PostMapping("/carInfo/updateCarInfo")
    //更新车辆信息
    public ResponseDTO addCar(@RequestBody CarInfo carInfo) {
        return new ResponseDTO(Code.SUCCESS, Msg.UPD_SUCCESS_MSG,carInfoService.updateCarInfo(carInfo));
    }
}
