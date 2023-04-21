package com.oracledb.retrieve.oraclefast.services;

import com.oracledb.retrieve.oraclefast.models.ResultFM;
import com.oracledb.retrieve.oraclefast.repositories.ResultFMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ResultFMService {
    @Autowired
    private ResultFMRepository resultFMRepository;

    public List<ResultFM> findByMessOfmId(BigDecimal id) {
        return resultFMRepository.findAllByMessOfmId(id);
    }

}
