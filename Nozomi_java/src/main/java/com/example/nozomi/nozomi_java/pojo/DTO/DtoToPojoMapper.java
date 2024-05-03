package com.example.nozomi.nozomi_java.pojo.DTO;

import com.example.nozomi.nozomi_java.pojo.Car;
import com.example.nozomi.nozomi_java.pojo.UserCar;
import org.springframework.stereotype.Service;

/**
 * 手动映射类
 */
@Service
public class DtoToPojoMapper {
    public Car mapDtotoCar(CarUserCarDTO dto) {
        Car car = new Car();
        car.setCarCover(dto.getCarCover());
        car.setCarTitle(dto.getCarTitle());
        car.setCarAbstract(dto.getCarAbstract());
        car.setPrice(dto.getPrice());
        car.setSellingPrice(dto.getSellingPrice());
        return car;
    }
    public UserCar mapDtoToUserCar(CarUserCarDTO dto) {
        UserCar userCar = new UserCar();
        userCar.setCarId(dto.getCarId());
        userCar.setUserId(dto.getUserId());
        return userCar;
    }
}
