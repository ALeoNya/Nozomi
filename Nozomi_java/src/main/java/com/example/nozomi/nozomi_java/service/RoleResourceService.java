package com.example.nozomi.nozomi_java.service;

import com.example.nozomi.nozomi_java.pojo.DTO.ResponseDTO;
import com.example.nozomi.nozomi_java.pojo.RoleResource;

public interface RoleResourceService {
    public ResponseDTO addRoleResource(RoleResource roleResource);
    public ResponseDTO delRoleResource(RoleResource roleResource);
    public ResponseDTO selRoleResourceById(RoleResource roleResource);
    public ResponseDTO selAllResourceIdById(RoleResource roleResource);
    public ResponseDTO allRoleResource(RoleResource roleResource);
    public ResponseDTO updRoleResource(RoleResource roleResource);
}
