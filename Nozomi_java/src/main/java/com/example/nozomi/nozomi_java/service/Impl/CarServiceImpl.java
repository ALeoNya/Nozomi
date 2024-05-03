package com.example.nozomi.nozomi_java.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.nozomi.nozomi_java.mapper.CarInfoMapper;
import com.example.nozomi.nozomi_java.mapper.CarMapper;
import com.example.nozomi.nozomi_java.mapper.UserCarMapper;
import com.example.nozomi.nozomi_java.mapper.UserLikeMapper;
import com.example.nozomi.nozomi_java.pojo.Car;
import com.example.nozomi.nozomi_java.pojo.CarInfo;
import com.example.nozomi.nozomi_java.pojo.DTO.CarSelectDTO;
import com.example.nozomi.nozomi_java.pojo.DTO.CarUserCarDTO;
import com.example.nozomi.nozomi_java.pojo.DTO.DtoToPojoMapper;
import com.example.nozomi.nozomi_java.pojo.UserCar;
import com.example.nozomi.nozomi_java.pojo.Wrapper.CarWrapper;
import com.example.nozomi.nozomi_java.service.CarInfoService;
import com.example.nozomi.nozomi_java.service.CarService;
import com.example.nozomi.nozomi_java.service.UserCarService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@Service("CarService")
public class CarServiceImpl implements CarService {
    @Resource
    private CarMapper carMapper;
    @Resource
    private UserCarMapper userCarMapper;
    @Resource
    private CarInfoMapper carInfoMapper;
    @Resource
    private DtoToPojoMapper dtoToPojoMapper;
    //开启事务
    @Transactional
    public boolean addCar(CarUserCarDTO dto) {
        try {
            CarInfo carInfo = new CarInfo();
            UserCar userCar = dtoToPojoMapper.mapDtoToUserCar(dto);
            // add Car TABLE
            carMapper.autoIncrement();
            carMapper.insert(dtoToPojoMapper.mapDtotoCar(dto));
            int carId = carMapper.lastInsertId();
            carInfo.setId(carId);
            carInfoMapper.autoIncrement();
            carInfoMapper.insert(carInfo);
            // 更新表car的info_id
            carMapper.updateInfoId();
            // 需要carId和userId
            userCar.setCarId(carId);
            userCarMapper.autoIncrement();
            userCarMapper.insert(userCar);
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
    public List<Car> getCarByCondition(CarSelectDTO dto) {
        return carMapper.getCarByCondition(dto);
//        QueryWrapper<Car> queryWrapper = new QueryWrapper<>();
//        // 处理可能为 NULL 的 price 参数
//        if (dto.getPrice() != null) {
//            queryWrapper.eq("price", dto.getPrice());
//        }
//
//        // 处理可能为 NULL 的 selling_price 参数
//        if (dto.getSellingPrice() != null) {
//            queryWrapper.eq("selling_price", dto.getSellingPrice());
//        }
//
//        // 处理可能为 NULL 的 create_time 范围参数
//        if (dto.getStartTime() != null && dto.getEndTime() != null) {
//            queryWrapper.between("create_time", dto.getStartTime(), dto.getEndTime());
//        }
//        return carMapper.selectList(queryWrapper);
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

}
