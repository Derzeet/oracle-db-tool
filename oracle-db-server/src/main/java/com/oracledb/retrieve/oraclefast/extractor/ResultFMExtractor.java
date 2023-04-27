package com.oracledb.retrieve.oraclefast.extractor;

import com.oracledb.retrieve.oraclefast.models.ResultFM;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultFMExtractor implements ResultSetExtractor<List<ResultFM>> {
    @Override
    public List<ResultFM> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<ResultFM> data = new ArrayList<>();
        while (rs.next()) {
            ResultFM res = new ResultFM();
            res.setMessOfmId(rs.getBigDecimal("MESS_OFM_ID"));
            res.setMessNumber(rs.getBigDecimal("MESS_NUMBER"));
            res.setMessDate(rs.getDate("MESS_DATE"));
            res.setMessType(rs.getString("MESS_TYPE"));
            res.setOperStatus(rs.getString("OPER_STATUS"));
            res.setMessReason(rs.getString("MESS_REASON"));
            res.setCfmCode(rs.getBigDecimal("CFM_CODE"));
            res.setCfmName(rs.getString("CFM_NAME"));
            res.setCfmMainCode(rs.getString("CFM_MAINCODE"));
            res.setCfmSeatArea(rs.getString("CFM_SEAT_AREA"));
            res.setCfmSeatRegion(rs.getString("CFM_SEAT_REGION"));
            res.setCfmSeatCity(rs.getString("CFM_SEAT_SITY"));
            res.setCfmSeatStreet(rs.getString("CFM_SEAT_STREET"));
            res.setCfmSeatHouse(rs.getString("CFM_SEAT_HOUSE"));
            res.setCfmSeatOffice(rs.getString("CFM_SEAT_OFFICE"));
            res.setCfmSeatPostcode(rs.getString("CFM_SEAT_POSTCODE"));
            res.setCfmIsac(rs.getBigDecimal("CFM_ISAC"));
            res.setDocType(rs.getString("DOC_TYPE"));
            res.setCfmDocNumber(rs.getString("CFM_DOC_NUMBER"));
            res.setCfmDocSeries(rs.getString("CFM_DOC_SERIES"));
            res.setCfmDocWhom(rs.getString("CFM_DOC_WHOM"));
            res.setCfmDocDate(rs.getDate("CFM_DOC_DATE"));
            res.setOperNumber(rs.getString("OPER_NUMBER"));
            res.setOperType(rs.getString("OPER_TYPE"));
            res.setOperPaymentPurpose(rs.getString("назначение платежа"));
            res.setOperMembersCount(rs.getBigDecimal("OPER_MEMBERS_COUNT"));
            res.setCurrencyType(rs.getString("CURRENCY_TYPE"));
            res.setOperCurrencyAmount(rs.getBigDecimal("OPER_CURRENCY_AMOUNT"));
            res.setOperTengeAmount(rs.getBigDecimal("OPER_TENGE_AMOUNT"));
            res.setOperReason(rs.getString("OPER_REASON"));
            res.setOperDocDate(rs.getDate("OPER_DOC_DATE"));
            res.setOperDocNumber(rs.getString("OPER_DOC_NUMBER"));
            res.setSuspFirst(rs.getString("SUSP_FIRST"));
            res.setSuspSecond(rs.getString("SUSP_SECOND"));
            res.setSuspThird(rs.getString("SUSP_THIRD"));
            res.setOperDopInfo(rs.getString("OPER_DOPINFO"));
            res.setMemberId(rs.getBigDecimal("MEMBER_ID"));
            res.setMemberVid(rs.getString("MEMBER_VID"));
            res.setMemberResidence(rs.getBigDecimal("MEMBER_RESIDENCE"));
            res.setMemberResidenceCountrycode(rs.getBigDecimal("MEMBER_RESIDENCE_COUNTRYCODE"));
            res.setMemberType(rs.getString("MEMBER_TYPE"));
            res.setMemberForeign(rs.getString("MEMBER_FOREIGN"));
            res.setMemberBankCode(rs.getString("MEMBER_BANK_CODE"));
            res.setMemberBankName(rs.getString("MEMBER_BANK_NAME"));
            res.setMemberBankAccount(rs.getString("MEMBER_BANK_ACCOUNT"));
            res.setMemberBankAddress(rs.getString("MEMBER_BANK_ADDRESS"));
            res.setMemberUrName(rs.getString("MEMBER_UR_NAME"));
            res.setMemberUrFistHeadName(rs.getString("MEMBER_UR_FISTHEAD_NAME"));
            res.setMemberOked(rs.getString("MEMBER_OKED"));
            res.setMemberMaincode(rs.getString("MEMBER_MAINCODE"));
            res.setMemberAcFirstName(rs.getString("MEMBER_AC_FIRSTNAME"));
            res.setMemberAcSecondName(rs.getString("MEMBER_AC_SECONDNAME"));
            res.setMemberAcMiddlename(rs.getString("MEMBER_AC_MIDDLENAME"));
            res.setMemberAcDocType(rs.getString("MEMBER_AC_DOC_TYPE"));
            res.setMemberAcDocSeries(rs.getString("MEMBER_AC_DOC_SERIES"));
            res.setMemberAcDocWhom(rs.getString("MEMBER_AC_DOC_WHOM"));
            res.setMemberAcDocDate(rs.getDate("MEMBER_AC_DOC_DATE"));
            res.setMemberAcBirthDate(rs.getDate("MEMBER_AC_BIRTH_DATE"));
            res.setMemberAcBirthPlace(rs.getString("MEMBER_AC_BIRTH_PLACE"));
            res.setMemberRegArea(rs.getString("MEMBER_REG_AREA"));
            res.setMemberRegRegion(rs.getString("MEMBER_REG_REGION"));
            res.setMemberRegSity(rs.getString("MEMBER_REG_SITY"));
            res.setMemberRegStreet(rs.getString("MEMBER_REG_STREET"));
            res.setMemberRegHouse(rs.getString("MEMBER_REG_HOUSE"));
            res.setMemberRegOffice(rs.getString("MEMBER_REG_OFFICE"));
            res.setMemberPhone(rs.getString("MEMBER_PHONE"));
            res.setMemberEmail(rs.getString("MEMBER_EMAIL"));
            res.setMemberSeatArea(rs.getString("MEMBER_SEAT_AREA"));
            res.setMemberSeatRegion(rs.getString("MEMBER_SEAT_REGION"));
            res.setMemberSeatSity(rs.getString("MEMBER_SEAT_SITY"));
            res.setMemberSeatStreet(rs.getString("MEMBER_SEAT_STREET"));
            res.setMemberSeatHouse(rs.getString("MEMBER_SEAT_HOUSE"));
            res.setMemberSeatHouse(rs.getString("MEMBER_SEAT_OFFICE"));
            data.add(res);
        }
        return data;
    }
}
