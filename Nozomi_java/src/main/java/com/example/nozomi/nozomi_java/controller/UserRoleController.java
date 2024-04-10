package com.example.nozomi.nozomi_java.controller;

import com.example.nozomi.nozomi_java.pojo.DTO.ResponseDTO;
import com.example.nozomi.nozomi_java.pojo.UserRole;
import com.example.nozomi.nozomi_java.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @PostMapping("/addUserRole")
    public ResponseDTO addUserRole(@RequestBody UserRole UserRole) {
        return userRoleService.addUserRole(UserRole);
    }

    @PostMapping("/delUserR+ole")
    public ResponseDTO delUserRole(@RequestBody UserRole UserRole) {
        return userRoleService.delUserRole(UserRole);
    }

    @PostMapping("/selUserRoleById")
    public ResponseDTO selUserRoleById(@RequestBody UserRole UserRole) {
        return userRoleService.selUserRoleById(UserRole);
    }

    @PostMapping("/allUserRole")
    public ResponseDTO allUserRole(@RequestBody UserRole UserRole) {
        return userRoleService.allUserRole(UserRole);
    }

    @PostMapping("/updUserRole")
    public ResponseDTO updUserRole(@RequestBody UserRole UserRole) {
        return userRoleService.updUserRole(UserRole);
    }
}
