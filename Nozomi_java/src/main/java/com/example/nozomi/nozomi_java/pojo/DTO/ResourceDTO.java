package com.example.nozomi.nozomi_java.pojo.DTO;

import com.example.nozomi.nozomi_java.pojo.Resource;
import lombok.Data;

import java.util.List;

@Data
public class ResourceDTO {
    private Resource resource;
    private List<Resource> family;
}
