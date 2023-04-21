package com.oracledb.retrieve.oraclefast.controllers;

import com.oracledb.retrieve.oraclefast.models.ResultFM;
import com.oracledb.retrieve.oraclefast.services.ResultFMService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
public class BaseController {
    @Autowired
    private ResultFMService resultFMService;

    @GetMapping("/test")
    public String implementTest() {
        return "Success";
    }

    @GetMapping("/byid")
    public List<ResultFM> getByMessOfmId(@RequestParam BigDecimal messofmid) {
        return resultFMService.findByMessOfmId(messofmid);
    }
}
