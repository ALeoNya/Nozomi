package com.example.nozomi.nozomi_java.service;


import com.example.nozomi.nozomi_java.pojo.DTO.ResponseDTO;
import com.example.nozomi.nozomi_java.pojo.Role;

public interface RoleService {
    public ResponseDTO addRole(Role role);
    public ResponseDTO delRole(Role role);
    public ResponseDTO allRole();
    public ResponseDTO selRoleById(Role role);
    public ResponseDTO updRole(Role role);

}
