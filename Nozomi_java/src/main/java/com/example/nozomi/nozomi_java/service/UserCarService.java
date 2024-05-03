package com.example.nozomi.nozomi_java.service;

import com.example.nozomi.nozomi_java.pojo.UserCar;
import java.util.List;

public interface UserCarService {
    public boolean addUserCar(UserCar userCar);
    public List<Integer> getCarIdByUserId(int userId);
    public boolean changeSaleTypeByCarId(UserCar userCar);
    public boolean passMerchantStatus(int carId);
    public boolean cancelMerchantStatus(int carId);
}
