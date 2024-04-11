package com.example.nozomi.nozomi_java.service;

import com.example.nozomi.nozomi_java.pojo.Car;

import java.util.List;

public interface UserCarService {
    public List<Integer> getCarIdByUserId(int userId);
}
