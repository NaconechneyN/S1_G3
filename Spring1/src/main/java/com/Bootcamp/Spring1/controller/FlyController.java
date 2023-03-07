package com.Bootcamp.Spring1.controller;

import com.Bootcamp.Spring1.model.FlyModel;
import com.Bootcamp.Spring1.service.FlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlyController {
    @Autowired
    FlyService flyService;

    @GetMapping("/api/v1/flights")
    public List<FlyModel> listFlyAvailable() {
        return flyService.flightsList();
    }
}
