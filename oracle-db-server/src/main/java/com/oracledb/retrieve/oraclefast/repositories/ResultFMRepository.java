package com.oracledb.retrieve.oraclefast.repositories;

import com.oracledb.retrieve.oraclefast.models.ResultFM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ResultFMRepository extends JpaRepository<ResultFM, BigDecimal> {
    List<ResultFM> findAllByMessOfmId(BigDecimal id);
}
