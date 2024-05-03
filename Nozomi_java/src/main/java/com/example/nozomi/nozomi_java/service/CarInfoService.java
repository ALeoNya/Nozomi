package com.example.nozomi.nozomi_java.service;

import com.example.nozomi.nozomi_java.pojo.CarInfo;

public interface CarInfoService {
    public boolean addCarInfoById(CarInfo carInfo);
    public boolean deleteCarInfoById(int infoId);
    public CarInfo getCarInfoById(int infoId);
    public boolean updateCarInfo(CarInfo carInfo);
}
