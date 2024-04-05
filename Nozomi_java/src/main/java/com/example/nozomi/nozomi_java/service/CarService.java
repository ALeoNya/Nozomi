package com.example.nozomi.nozomi_java.service;

import com.example.nozomi.nozomi_java.pojo.Car;

import java.util.List;

public interface CarService {
    boolean addCar(Car car);
    boolean deleteCar(int id);
    List<Car> carList();
    boolean updateCar(Car car);
}
