package com.example.nozomi.nozomi_java.service;

import com.example.nozomi.nozomi_java.pojo.DTO.ResponseDTO;
import com.example.nozomi.nozomi_java.pojo.UserRole;

public interface UserRoleService {
    public ResponseDTO addUserRole(UserRole userRole);
    public ResponseDTO delUserRole(UserRole userRole);
    public ResponseDTO allUserRole(UserRole userRole);
    public ResponseDTO selUserRoleById(UserRole userRole);
    public UserRole selUserRoleByUserId(int userid);
    public ResponseDTO updUserRole(UserRole userRole);

}
