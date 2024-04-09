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
    /**
     * 增加
     * @param car
     * @return
     */
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



    // TODO 1.实现点赞功能，2.记录观看人数及其观看时间
    // 实现点赞
    //拼接key  userId:carId  点赞value=1 取消点赞value=0 写入redis
    //定时任务，2h将redis点赞的key写入DB，判断是否在DB已存在点赞关系，改变点赞字段;


    //TODO 实现季度（出库）价格记录
}
