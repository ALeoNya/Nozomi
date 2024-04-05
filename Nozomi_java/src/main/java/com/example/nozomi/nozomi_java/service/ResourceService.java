package com.example.nozomi.nozomi_java.service;


import com.example.nozomi.nozomi_java.pojo.DTO.ResponseDTO;
import com.example.nozomi.nozomi_java.pojo.Resource;

public interface ResourceService {
    public ResponseDTO addResource(Resource resource);
    public ResponseDTO delResource(Resource resource);
    public ResponseDTO selResourceById(Resource resource);
    public ResponseDTO allResource();
    public ResponseDTO allResourceByType();
    public ResponseDTO allResourceByTree();
    public ResponseDTO updResource(Resource resource);
}
