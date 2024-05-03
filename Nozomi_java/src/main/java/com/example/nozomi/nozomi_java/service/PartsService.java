package com.example.nozomi.nozomi_java.service;

import com.example.nozomi.nozomi_java.pojo.Car;
import com.example.nozomi.nozomi_java.pojo.DTO.CarSelectDTO;
import com.example.nozomi.nozomi_java.pojo.DTO.CarUserCarDTO;

import java.util.List;

public interface PartsService {
    boolean addCar(CarUserCarDTO dto);
    boolean deleteCar(int id);
    List<Car> carList();
    List<Car> getCarByCondition(CarSelectDTO dto);
    boolean updateCar(Car car);
    List<Car> getCarByUserId(int userId);
}
