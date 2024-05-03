package com.example.nozomi.nozomi_java.pojo.Wrapper;

import com.example.nozomi.nozomi_java.pojo.Car;
import com.example.nozomi.nozomi_java.pojo.CarInfo;
import com.example.nozomi.nozomi_java.pojo.UserCar;
import lombok.Data;

@Data
public class CarWrapper {
    private Car car;
    private CarInfo carInfo;
    private UserCar userCar;
}
