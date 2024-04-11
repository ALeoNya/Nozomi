package com.example.nozomi.nozomi_java.service.Impl;

import com.example.nozomi.nozomi_java.mapper.CarMapper;
import com.example.nozomi.nozomi_java.mapper.UserLikeMapper;
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
            carMapper.autoIncrement();
            carMapper.insert(car);
            return true;
        } catch (RuntimeException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    // 真删除
    public boolean deleteCar(int id) {
        try {
            carMapper.deleteById(id);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    @Override
    // 获取未售出的车辆列表
    public List<Car> carList() {
        return carMapper.getSellingCar();
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

    @Override
    public List<Car> getCarByUserId(int userId) {
        return carMapper.getCarListByUserId(userId);
    }

    // TODO 实现寄售


    //TODO 实现季度（出库）价格记录
}
