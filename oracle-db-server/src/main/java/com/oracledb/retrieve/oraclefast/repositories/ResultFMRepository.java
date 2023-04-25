package com.oracledb.retrieve.oraclefast.repositories;

import com.oracledb.retrieve.oraclefast.models.ResultFM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository

public interface ResultFMRepository extends JpaRepository<ResultFM, BigDecimal> {
    List<ResultFM> findAllByMessOfmId(BigDecimal id);

    @Query(value = "SELECT * FROM KFM.RESULT_FM rf WHERE rf.CFM_MAINCODE = ?1 AND MESS_DATE>TO_DATE('2023-02-26', 'YYYY-MM-DD') FETCH NEXT 10 ROWS ONLY ", nativeQuery = true)
    List<ResultFM> findAllByCfmMainCode(String main);
    List<ResultFM> findAllByMessNumber(BigDecimal number);
    List<ResultFM> findAllByCfmName(String name);
    List<ResultFM> findAllByOperNumber(String main);
    List<ResultFM> findAllByMemberMaincode(String main);

//    List<ResultFM> findAllByCfmMainCodeOrMessNumberAndCfmNameAndOperNumberAndMemberMaincode(String cfm, BigDecimal number, String cfmname, String oper, String member);
//    List<ResultFM> findAllByCfmMainCodeOrMessNumberOrCfmNameAndOperNumberAndMemberMaincode(String cfm, BigDecimal number, String cfmname, String oper, String member);
//    List<ResultFM> findAllByCfmMainCodeOrMessNumberAndCfmNameOrOperNumberAndMemberMaincode(String cfm, BigDecimal number, String cfmname, String oper, String member);
//    List<ResultFM> findAllByCfmMainCodeOrMessNumberAndCfmNameAndOperNumberOrMemberMaincode(String cfm, BigDecimal number, String cfmname, String oper, String member);
//
//
//    List<ResultFM> findAllByCfmMainCodeAndMessNumberOrCfmNameAndOperNumberAndMemberMaincode(String cfm, BigDecimal number, String cfmname, String oper, String member);
//    List<ResultFM> findAllByCfmMainCodeAndMessNumberAndCfmNameOrOperNumberAndMemberMaincode(String cfm, BigDecimal number, String cfmname, String oper, String member);
//    List<ResultFM> findAllByCfmMainCodeAndMessNumberAndCfmNameAndOperNumberOrMemberMaincode(String cfm, BigDecimal number, String cfmname, String oper, String member);
//    List<ResultFM> findAllByCfmMainCodeAndMessNumberAndCfmNameAndOperNumberAndMemberMaincode(String cfm, BigDecimal number, String cfmname, String oper, String member);
//
//    // CFM MAINCODE, CFM NAME, OPERNUMBER, MEMBER MAINCODE
//    List<ResultFM> findAllByCfmMainCodeAndCfmNameAndOperNumberAndMemberMaincode(String cfm, BigDecimal number, String cfmname, String oper, String member);
//    List<ResultFM> findAllByCfmMainCodeOrCfmNameAndOperNumberAndMemberMaincode(String cfm, BigDecimal number, String cfmname, String oper, String member);
//    List<ResultFM> findAllByCfmMainCodeAndCfmNameOrOperNumberAndMemberMaincode(String cfm, BigDecimal number, String cfmname, String oper, String member);
//    List<ResultFM> findAllByCfmMainCodeAndCfmNameAndOperNumberOrMemberMaincode(String cfm, BigDecimal number, String cfmname, String oper, String member);
//
//
//
//
//
//    List<ResultFM> findAllByCfmMainCodeAndMessNumberAndOperNumberAndMemberMaincode(String cfm, BigDecimal number, String cfmname, String oper, String member);
//    List<ResultFM> findAllByCfmMainCodeAndMessNumberAndCfmNameAndMemberMaincode(String cfm, BigDecimal number, String cfmname, String member);
//    List<ResultFM> findAllByCfmMainCodeAndMessNumberAndCfmNameAndOperNumber(String cfm, BigDecimal number, String cfmname, String oper);
//
//    //    CFM MAINCODE AND MESS NUMBER *********************************************************************************
//    List<ResultFM> findAllByCfmMainCodeAndMessNumber(String main, BigDecimal number);
//
//    List<ResultFM> findAllByCfmMainCodeAndMessNumberAndCfmName(String main, BigDecimal number, String name);
//    List<ResultFM> findAllByCfmMainCodeAndMessNumberAndOperNumber(String main, BigDecimal number, String name);
//    List<ResultFM> findAllByCfmMainCodeAndMessNumberAndMemberMaincode(String main, BigDecimal number, String name);
//
//    List<ResultFM> findAllByCfmMainCodeAndMessNumberOrCfmName(String main, BigDecimal number, String name);
//    List<ResultFM> findAllByCfmMainCodeAndMessNumberOrOperNumber(String main, BigDecimal number, String name);
//    List<ResultFM> findAllByCfmMainCodeAndMessNumberOrMemberMaincode(String main, BigDecimal number, String name);
//    //OR ***********************************************************
//    List<ResultFM> findAllByCfmMainCodeOrMessNumber(String main, BigDecimal number);
//    List<ResultFM> findAllByCfmMainCodeOrMessNumberAndCfmName(String main, BigDecimal number, String name);
//    List<ResultFM> findAllByCfmMainCodeOrMessNumberAndOperNumber(String main, BigDecimal number, String name);
//    List<ResultFM> findAllByCfmMainCodeOrMessNumberAndMemberMaincode(String main, BigDecimal number, String name);
//
//    List<ResultFM> findAllByCfmMainCodeOrMessNumberOrCfmName(String main, BigDecimal number, String name);
//    List<ResultFM> findAllByCfmMainCodeOrMessNumberOrOperNumber(String main, BigDecimal number, String name);
//    List<ResultFM> findAllByCfmMainCodeOrMessNumberOrMemberMaincode(String main, BigDecimal number, String name);
//
//    //    CFM MAINCODE AND CFM NAME ************************************************************************************
//    List<ResultFM> findAllByCfmMainCodeAndCfmName(String main, String name);
//    List<ResultFM> findAllByCfmMainCodeAndOperNumber(String main, String number);
//    List<ResultFM> findAllByCfmMainCodeAndMemberMaincode(String main, String memberMain);
//    List<ResultFM> findAllByMessNumberAndMemberMaincode(BigDecimal main, String memberMain);
//    List<ResultFM> findAllByMessNumberAndCfmName(BigDecimal main, String memberMain);
//    List<ResultFM> findAllByMessNumberAndOperNumber(BigDecimal main, String memberMain);
//    List<ResultFM> findAllByCfmNameAndOperNumber(String main, String memberMain);
//    List<ResultFM> findAllByCfmNameAndMemberMaincode(String main, String memberMain);
//    List<ResultFM> findAllByOperNumberAndMemberMaincode(String main, String memberMain);
//    List<ResultFM> findAllByCfmMainCodeOrCfmName(String main, String name);
//    List<ResultFM> findAllByCfmMainCodeOrOperNumber(String main, String number);
//    List<ResultFM> findAllByCfmMainCodeOrMemberMaincode(String main, String memberMain);
//    List<ResultFM> findAllByMessNumberOrMemberMaincode(BigDecimal main, String memberMain);
//    List<ResultFM> findAllByMessNumberOrCfmName(BigDecimal main, String memberMain);
//    List<ResultFM> findAllByMessNumberOrOperNumber(BigDecimal main, String memberMain);
//    List<ResultFM> findAllByCfmNameOrOperNumber(String main, String memberMain);
//    List<ResultFM> findAllByCfmNameOrMemberMaincode(String main, String memberMain);
//    List<ResultFM> findAllByOperNumberOrMemberMaincode(String main, String memberMain);

}
