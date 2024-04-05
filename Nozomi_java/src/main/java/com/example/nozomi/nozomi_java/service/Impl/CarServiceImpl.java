package com.example.nozomi.nozomi_java.service.Impl;

import com.example.nozomi.nozomi_java.mapper.CarMapper;
import com.example.nozomi.nozomi_java.pojo.Car;
import com.example.nozomi.nozomi_java.service.CarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("CarService")
public class CarServiceImpl implements CarService {
    @Resource
    private CarMapper carMapper;
    @Override
    public boolean addCar(Car car) {
        try {
            carMapper.insert(car);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    @Override
    public boolean deleteCar(int id) {
        try {
            carMapper.deleteById(id);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    @Override
    public List<Car> carList() {
        return carMapper.selectList(null);
    }

    @Override
    public boolean updateCar(Car car) {
        try {
            carMapper.updateById(car);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}
