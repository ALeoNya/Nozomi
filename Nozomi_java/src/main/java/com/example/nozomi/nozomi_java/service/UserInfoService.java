package com.example.nozomi.nozomi_java.service;

import com.example.nozomi.nozomi_java.pojo.DTO.ResponseDTO;
import com.example.nozomi.nozomi_java.pojo.UserInfo;

public interface UserInfoService {
    public ResponseDTO addUserInfo(UserInfo userInfo);
    public ResponseDTO delUserInfo(UserInfo userInfo);
    public ResponseDTO allUserInfo(UserInfo userInfo);
    public ResponseDTO selUserInfoById(UserInfo userInfo);
    public ResponseDTO updUserInfo(UserInfo userInfo);

}
