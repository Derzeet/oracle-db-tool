package com.oracledb.retrieve.oraclefast.services;

import com.oracledb.retrieve.oraclefast.models.ResultFM;
import com.oracledb.retrieve.oraclefast.repositories.ResultFMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ResultFMService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ResultFMRepository resultFMRepository;

    public List<ResultFM> findByMessOfmId(BigDecimal id) {
        List<ResultFM> l = resultFMRepository.findAllByCfmMainCode("940140000385");
        return l;
    }

    private List<ResultFM> getList(String sql) {
        List<ResultFM> resultFMS = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ResultFM.class));
        return resultFMS;
    }

    public String getSql(String sql, Integer i, HashMap<String, String> req) {
        HashMap<String, String> dict = new HashMap<>();
        dict.put("cfmMainCode", "CFM_MAINCODE");
        dict.put("messNumber", "MESS_NUMBER");
        dict.put("cfmName", "CFM_NAME");
        dict.put("operNumber", "OPER_NUMBER");
        dict.put("memberMaincode", "MEMBER_MAINCODE");
        String aOr = "aOr" + i;
        int number = i + 1;

        if (req.get(aOr).equals("none") || req.get("value" + number).equals("")) {
            System.out.println(" req.get(aOr).equals(\"none\") || req.get(\"value\" + number).equals(\"\")");
            System.out.println(sql + " returned");
            return sql;
        } else if (req.get(aOr).equals("and") && !req.get("value" + number).equals("")) {
            if (req.get("filter" + number).equals("messNumber")) {
                sql = sql + " AND " + dict.get(req.get("filter" + number)) + " = " + req.get("value" + number);
            } else {
                sql = sql + " AND " + dict.get(req.get("filter" + number)) + " = '" + req.get("value" + number) + "'";
            }
            System.out.println(sql);
            if (i < 4) {
                System.out.println(i);
                sql = getSql(sql, number, req);
            }
        } else {
            if (req.get("filter" + number).equals("messNumber")) {
                sql = sql + " OR " + dict.get(req.get("filter" + number)) + " = " + req.get("value" + number);
            } else {
                sql = sql + " OR " + dict.get(req.get("filter" + number)) + " = '" + req.get("value" + number) + "'";
            }
            if (i < 4) {
                System.out.println(i);
                sql = getSql(sql, number, req);
            }
        }
        return sql;
    }

    public String getResults(HashMap<String, String> req) {
        System.out.println(req);
        HashMap<String, String> dict = new HashMap<>();
        dict.put("cfmMainCode", "CFM_MAINCODE");
        dict.put("messNumber", "MESS_NUMBER");
        dict.put("cfmName", "CFM_NAME");
        dict.put("operNumber", "OPER_NUMBER");
        dict.put("memberMaincode", "MEMBER_MAINCODE");
        String sql = "SELECT * FROM KFM.RESULT_FM WHERE ";
        if (req.get("value1").equals("")) {
            System.out.println("value1 is not empty");
            return null;
        } else {
            if (req.get("filter1").equals("messNumber")) {
                sql = sql + dict.get(req.get("filter1")) + " = " + req.get("value1") + "";
            } else {
                sql = sql + dict.get(req.get("filter1")) + " = '" + req.get("value1") + "'";
            }
            System.out.println(sql + " recursive method called");
            sql = getSql(sql, 1, req);
        }
//        List<ResultFM> r = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ResultFM.class));
        System.out.println(sql + "string to from method");
        return sql;
    }
}
