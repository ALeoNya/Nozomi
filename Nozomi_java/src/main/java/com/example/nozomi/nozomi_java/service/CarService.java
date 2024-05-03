package com.example.nozomi.nozomi_java.service;

import com.example.nozomi.nozomi_java.pojo.Car;
import com.example.nozomi.nozomi_java.pojo.CarInfo;
import com.example.nozomi.nozomi_java.pojo.DTO.CarSelectDTO;
import com.example.nozomi.nozomi_java.pojo.DTO.CarUserCarDTO;
import com.example.nozomi.nozomi_java.pojo.UserCar;
import com.example.nozomi.nozomi_java.pojo.Wrapper.CarWrapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

public interface CarService {
    boolean addCar(CarUserCarDTO dto);
    boolean deleteCar(int id);
    List<Car> carList();
    List<Car> getCarByCondition(CarSelectDTO dto);
    boolean updateCar(Car car);
    List<Car> getCarByUserId(int userId);
}
