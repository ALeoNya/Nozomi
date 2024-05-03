package com.example.nozomi.nozomi_java.controller;

import com.example.nozomi.nozomi_java.service.AftersalePartsService;
import com.example.nozomi.nozomi_java.service.AftersaleService;
import com.example.nozomi.nozomi_java.service.CarAftersaleService;
import com.example.nozomi.nozomi_java.service.PartsService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AfterSaleController {
    @Resource
    private CarAftersaleService carAftersaleService;
    @Resource
    private AftersaleService aftersaleService;
    @Resource
    private AftersalePartsService aftersalePartsService;
    @Resource
    private PartsService partsService;
}
