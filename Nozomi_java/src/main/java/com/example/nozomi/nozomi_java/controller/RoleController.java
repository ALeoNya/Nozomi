package com.example.nozomi.nozomi_java.controller;


import com.example.nozomi.nozomi_java.pojo.DTO.ResponseDTO;
import com.example.nozomi.nozomi_java.pojo.Role;
import com.example.nozomi.nozomi_java.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/role/addRole")
    public ResponseDTO addRole(@RequestBody Role Role) {
        return roleService.addRole(Role);
    }

    @PostMapping("/role/delRole")
    public ResponseDTO delRole(@RequestBody Role Role) {
        return roleService.delRole(Role);
    }

    @PostMapping("/role/selRoleById")
    public ResponseDTO selRoleById(@RequestBody Role Role) {
        return roleService.selRoleById(Role);
    }

    @PostMapping("/role/allRole")
    public ResponseDTO allRole() {
        return roleService.allRole();
    }

    @PostMapping("/role/updRole")
    public ResponseDTO updRole(@RequestBody Role Role) {
        return roleService.updRole(Role);
    }
}
