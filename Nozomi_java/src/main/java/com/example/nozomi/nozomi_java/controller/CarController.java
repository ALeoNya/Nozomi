package com.example.nozomi.nozomi_java.controller;

import com.example.nozomi.nozomi_java.pojo.Car;
import com.example.nozomi.nozomi_java.pojo.DTO.ResponseDTO;
import com.example.nozomi.nozomi_java.pojo.Response;
import com.example.nozomi.nozomi_java.response.Code;
import com.example.nozomi.nozomi_java.response.Msg;
import com.example.nozomi.nozomi_java.service.CarService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class CarController {
    @Resource
    private CarService carService;

    //    @PreAuthorize("hasAuthority('/article/addArticle')")  //权限颗粒度
    @PostMapping("/car/addCar")
    public Response addCar(@RequestBody Car car) {
        if(carService.addCar(car)){
            return new Response(Code.SUCCESS, Msg.ADD_SUCCESS_MSG);
        }
        return new Response(Code.FAILED, Msg.ADD_FAIL_MSG);
    }

    @PostMapping("/car/deleteCar")
    public Response deleteCar(@RequestBody int id) {
        if(carService.deleteCar(id)){
            return new Response(Code.SUCCESS, Msg.DEL_SUCCESS_MSG);
        }
        return new Response(Code.FAILED, Msg.DEL_FAIL_MSG);
    }

    @PostMapping("/car/getCarList")
    public ResponseDTO getCarList() {
            return new ResponseDTO(Code.SUCCESS, Msg.ADD_SUCCESS_MSG, "addArticle");
    }

    @PostMapping("/car/updateCar")
    public Response updateCar(@RequestBody Car car) {
        if(carService.updateCar(car)){
            return new Response(Code.SUCCESS, Msg.UPD_SUCCESS_MSG);
        }
        return new Response(Code.SUCCESS, Msg.UPD_FAIL_MSG);
    }
}
