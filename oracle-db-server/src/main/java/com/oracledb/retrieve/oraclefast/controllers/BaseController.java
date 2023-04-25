package com.oracledb.retrieve.oraclefast.controllers;

import com.oracledb.retrieve.oraclefast.models.ResultFM;
import com.oracledb.retrieve.oraclefast.models.request;
import com.oracledb.retrieve.oraclefast.repositories.ResultFMRepository;
import com.oracledb.retrieve.oraclefast.services.ResultFMService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3000)
public class BaseController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ResultFMRepository repo;
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

    @GetMapping("/get")
    public List<ResultFM> getData(@RequestParam HashMap<String, String> req) {
//        System.out.println(req);

//        List<ResultFM> r = resultFMService.getResults(req);
        String sql = resultFMService.getResults(req) + " FETCH NEXT 10 ROWS ONLY";
        System.out.println(resultFMService.getSql(sql, 1, req));
        List<ResultFM> r = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ResultFM.class));
        return r;
    }
}
