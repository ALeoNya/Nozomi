package com.example.nozomi.nozomi_java.controller;


import com.example.nozomi.nozomi_java.pojo.DTO.ResponseDTO;
import com.example.nozomi.nozomi_java.pojo.RoleResource;
import com.example.nozomi.nozomi_java.service.RoleResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RoleResourceController {
    @Autowired
    private RoleResourceService resourceService;
    @PostMapping("/addRoleResource")
    public ResponseDTO addRoleResource(@RequestBody RoleResource RoleResource) {
        return resourceService.addRoleResource(RoleResource);
    }

    @PostMapping("/delRoleResource")
    public ResponseDTO delRoleResource(@RequestBody RoleResource RoleResource) {
        return resourceService.delRoleResource(RoleResource);
    }

    @PostMapping("/selRoleResourceById")
    public ResponseDTO selRoleResourceById(@RequestBody RoleResource RoleResource) {
        return resourceService.selRoleResourceById(RoleResource);
    }

    @PostMapping("/roleResource/selAllResourceIdById")
    public ResponseDTO selAllResourceIdById(@RequestBody RoleResource RoleResource) {
        return resourceService.selAllResourceIdById(RoleResource);
    }

    @PostMapping("/allRoleResource")
    public ResponseDTO allRoleResource(@RequestBody RoleResource RoleResource) {
        return resourceService.allRoleResource(RoleResource);
    }

    @PostMapping("/updRoleResource")
    public ResponseDTO updRoleResource(@RequestBody RoleResource RoleResource) {
        return resourceService.updRoleResource(RoleResource);
    }
}
