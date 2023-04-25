package com.oracledb.retrieve.oraclefast.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "RESULT_FM", schema = "KFM")
public class ResultFM {
    @Id
    @Nullable
    @Column(name = "MESS_OFM_ID")
    private BigDecimal messOfmId;

    @Nullable
    @Column(name = "MESS_NUMBER")
    private BigDecimal messNumber;

    @Nullable
    @Column(name = "MESS_DATE")
    private Date messDate;

    @Nullable
    @Column(name = "MESS_TYPE")
    private String messType;

    @Nullable
    @Column(name = "OPER_STATUS")
    private String operStatus;

    @Nullable
    @Column(name = "MESS_REASON")
    private String messReason;

    @Nullable
    @Column(name = "CFM_CODE")
    private BigDecimal cfmCode;

    @Nullable
    @Column(name = "CFM_NAME")
    private String cfmName;

    @Column(name = "CFM_MAINCODE")
    private String cfmMainCode;

    @Nullable
    @Column(name = "CFM_SEAT_AREA")
    private String cfmSeatArea;

    @Nullable
    @Column(name = "CFM_SEAT_REGION")
    private String cfmSeatRegion;

    @Nullable
    @Column(name = "CFM_SEAT_SITY")
    private String cfmSeatCity;

    @Nullable
    @Column(name = "CFM_SEAT_STREET")
    private String cfmSeatStreet;

    @Nullable
    @Column(name = "CFM_SEAT_HOUSE")
    private String cfmSeatHouse;

    @Nullable
    @Column(name = "CFM_SEAT_OFFICE")
    private String cfmSeatOffice;

    @Nullable
    @Column(name = "CFM_SEAT_POSTCODE")
    private String cfmSeatPostcode;

    @Nullable
    @Column(name = "CFM_ISAC")
    private BigDecimal cfmIsac;

    @Nullable
    @Column(name = "DOC_TYPE")
    private String docType;

    @Nullable
    @Column(name = "CFM_DOC_NUMBER")
    private String cfmDocNumber;

    @Nullable
    @Column(name = "CFM_DOC_SERIES")
    private String cfmDocSeries;

    @Nullable
    @Column(name = "CFM_DOC_WHOM")
    private String cfmDocWhom;

    @Nullable
    @Column(name = "CFM_DOC_DATE")
    private Date cfmDocDate;

    @Nullable
    @Column(name = "OPER_NUMBER")
    private String operNumber;

    @Nullable
    @Column(name = "OPER_TYPE")
    private String operType;

    @Nullable
    @Column(name = "назначение платежа")
    private String operPaymentPurpose;

    @Nullable
    @Column(name = "OPER_MEMBERS_COUNT")
    private BigDecimal operMembersCount;

    @Nullable
    @Column(name = "CURRENCY_TYPE")
    private String currencyType;

    @Nullable
    @Column(name = "OPER_CURRENCY_AMOUNT")
    private BigDecimal operCurrencyAmount;

    @Nullable
    @Column(name = "OPER_TENGE_AMOUNT")
    private BigDecimal operTengeAmount;

    @Nullable
    @Column(name = "OPER_REASON")
    private String operReason;

    @Nullable
    @Column(name = "OPER_DOC_DATE")
    private Date operDocDate;

    @Nullable
    @Column(name = "OPER_DOC_NUMBER")
    private String operDocNumber;

    @Nullable
    @Column(name = "SUSP_FIRST")
    private String suspFirst;

    @Nullable
    @Column(name = "SUSP_SECOND")
    private String suspSecond;

    @Nullable
    @Column(name = "SUSP_THIRD")
    private String suspThird;

    @Nullable
    @Column(name = "OPER_DOPINFO")
    private String operDopInfo;

    @Nullable
    @Column(name = "MEMBER_ID")
    private BigDecimal memberId;

    @Nullable
    @Column(name = "MEMBER_VID")
    private String memberVid;

    @Nullable
    @Column(name = "MEMBER_RESIDENCE")
    private BigDecimal memberResidence;

    @Nullable
    @Column(name = "MEMBER_RESIDENCE_COUNTRYCODE")
    private BigDecimal memberResidenceCountrycode;

    @Nullable
    @Column(name = "MEMBER_TYPE")
    private String memberType;

    @Nullable
    @Column(name = "MEMBER_FOREIGN")
    private String memberForeign;

    @Nullable
    @Column(name = "MEMBER_BANK_CODE")
    private String memberBankCode;

    @Nullable
    @Column(name = "MEMBER_BANK_NAME")
    private String memberBankName;

    @Nullable
    @Column(name = "MEMBER_BANK_ACCOUNT")
    private String memberBankAccount;

    @Nullable
    @Column(name = "MEMBER_BANK_ADDRESS")
    private String memberBankAddress;

    @Nullable
    @Column(name = "MEMBER_UR_NAME")
    private String memberUrName;

    @Nullable
    @Column(name = "MEMBER_UR_FISTHEAD_NAME")
    private String memberUrFistHeadName;

    @Nullable
    @Column(name = "MEMBER_OKED")
    private String memberOked;

    @Nullable
    @Column(name = "MEMBER_MAINCODE")
    private String memberMaincode;

    @Nullable
    @Column(name = "MEMBER_AC_FIRSTNAME")
    private String memberAcFirstName;

    @Nullable
    @Column(name = "MEMBER_AC_SECONDNAME")
    private String memberAcSecondName;

    @Nullable
    @Column(name = "MEMBER_AC_MIDDLENAME")
    private String memberAcMiddlename;

    @Nullable
    @Column(name = "MEMBER_AC_DOC_TYPE")
    private String memberAcDocType;

    @Nullable
    @Column(name = "MEMBER_AC_DOC_SERIES")
    private String memberAcDocSeries;

    @Nullable
    @Column(name = "MEMBER_AC_DOC_WHOM")
    private String memberAcDocWhom;

    @Nullable
    @Column(name = "MEMBER_AC_DOC_DATE")
    private Date memberAcDocDate;

    @Nullable
    @Column(name = "MEMBER_AC_BIRTH_DATE")
    private Date memberAcBirthDate;

    @Nullable
    @Column(name = "MEMBER_AC_BIRTH_PLACE")
    private String memberAcBirthPlace;

    @Nullable
    @Column(name = "MEMBER_REG_AREA")
    private String memberRegArea;

    @Nullable
    @Column(name = "MEMBER_REG_REGION")
    private String memberRegRegion;

    @Nullable
    @Column(name = "MEMBER_REG_SITY")
    private String memberRegSity;

    @Nullable
    @Column(name = "MEMBER_REG_STREET")
    private String memberRegStreet;

    @Nullable
    @Column(name = "MEMBER_REG_HOUSE")
    private String memberRegHouse;

    @Nullable
    @Column(name = "MEMBER_REG_OFFICE")
    private String memberRegOffice;

    @Nullable
    @Column(name = "MEMBER_PHONE")
    private String memberPhone;

    @Nullable
    @Column(name = "MEMBER_EMAIL")
    private String memberEmail;

    @Nullable
    @Column(name = "MEMBER_SEAT_AREA")
    private String memberSeatArea;

    @Nullable
    @Column(name = "MEMBER_SEAT_REGION")
    private String memberSeatRegion;

    @Nullable
    @Column(name = "MEMBER_SEAT_SITY")
    private String memberSeatSity;

    @Nullable
    @Column(name = "MEMBER_SEAT_STREET")
    private String memberSeatStreet;

    @Nullable
    @Column(name = "MEMBER_SEAT_HOUSE")
    private String memberSeatHouse;

    @Nullable
    @Column(name = "MEMBER_SEAT_OFFICE")
    private String memberSeatOffice;
    public BigDecimal getMessOfmId() {
        return messOfmId;
    }

    public void setMessOfmId(BigDecimal messOfmId) {
        this.messOfmId = messOfmId;
    }

    public BigDecimal getMessNumber() {
        return messNumber;
    }

    public void setMessNumber(BigDecimal messNumber) {
        this.messNumber = messNumber;
    }

    public Date getMessDate() {
        return messDate;
    }

    public void setMessDate(Date messDate) {
        this.messDate = messDate;
    }

    public String getMessType() {
        return messType;
    }

    public void setMessType(String messType) {
        this.messType = messType;
    }

    public String getOperStatus() {
        return operStatus;
    }

    public void setOperStatus(String operStatus) {
        this.operStatus = operStatus;
    }

    public String getMessReason() {
        return messReason;
    }

    public void setMessReason(String messReason) {
        this.messReason = messReason;
    }

    public BigDecimal getCfmCode() {
        return cfmCode;
    }

    public void setCfmCode(BigDecimal cfmCode) {
        this.cfmCode = cfmCode;
    }

    public String getCfmName() {
        return cfmName;
    }

    public void setCfmName(String cfmName) {
        this.cfmName = cfmName;
    }

    public String getCfmMainCode() {
        return cfmMainCode;
    }

    public void setCfmMainCode(String cfmMainCode) {
        this.cfmMainCode = cfmMainCode;
    }

    public String getCfmSeatArea() {
        return cfmSeatArea;
    }

    public void setCfmSeatArea(String cfmSeatArea) {
        this.cfmSeatArea = cfmSeatArea;
    }

    public String getCfmSeatRegion() {
        return cfmSeatRegion;
    }

    public void setCfmSeatRegion(String cfmSeatRegion) {
        this.cfmSeatRegion = cfmSeatRegion;
    }

    public String getCfmSeatCity() {
        return cfmSeatCity;
    }

    public void setCfmSeatCity(String cfmSeatCity) {
        this.cfmSeatCity = cfmSeatCity;
    }

    public String getCfmSeatStreet() {
        return cfmSeatStreet;
    }

    public void setCfmSeatStreet(String cfmSeatStreet) {
        this.cfmSeatStreet = cfmSeatStreet;
    }

    public String getCfmSeatHouse() {
        return cfmSeatHouse;
    }

    public void setCfmSeatHouse(String cfmSeatHouse) {
        this.cfmSeatHouse = cfmSeatHouse;
    }

    public String getCfmSeatOffice() {
        return cfmSeatOffice;
    }

    public void setCfmSeatOffice(String cfmSeatOffice) {
        this.cfmSeatOffice = cfmSeatOffice;
    }

    public String getCfmSeatPostcode() {
        return cfmSeatPostcode;
    }

    public void setCfmSeatPostcode(String cfmSeatPostcode) {
        this.cfmSeatPostcode = cfmSeatPostcode;
    }

    public BigDecimal getCfmIsac() {
        return cfmIsac;
    }

    public void setCfmIsac(BigDecimal cfmIsac) {
        this.cfmIsac = cfmIsac;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getCfmDocNumber() {
        return cfmDocNumber;
    }

    public void setCfmDocNumber(String cfmDocNumber) {
        this.cfmDocNumber = cfmDocNumber;
    }

    public String getCfmDocSeries() {
        return cfmDocSeries;
    }

    public void setCfmDocSeries(String cfmDocSeries) {
        this.cfmDocSeries = cfmDocSeries;
    }

    public String getCfmDocWhom() {
        return cfmDocWhom;
    }

    public void setCfmDocWhom(String cfmDocWhom) {
        this.cfmDocWhom = cfmDocWhom;
    }

    public Date getCfmDocDate() {
        return cfmDocDate;
    }

    public void setCfmDocDate(Date cfmDocDate) {
        this.cfmDocDate = cfmDocDate;
    }

    public String getOperNumber() {
        return operNumber;
    }

    public void setOperNumber(String operNumber) {
        this.operNumber = operNumber;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public String getOperPaymentPurpose() {
        return operPaymentPurpose;
    }

    public void setOperPaymentPurpose(String operPaymentPurpose) {
        this.operPaymentPurpose = operPaymentPurpose;
    }

    public BigDecimal getOperMembersCount() {
        return operMembersCount;
    }

    public void setOperMembersCount(BigDecimal operMembersCount) {
        this.operMembersCount = operMembersCount;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public BigDecimal getOperCurrencyAmount() {
        return operCurrencyAmount;
    }

    public void setOperCurrencyAmount(BigDecimal operCurrencyAmount) {
        this.operCurrencyAmount = operCurrencyAmount;
    }

    public BigDecimal getOperTengeAmount() {
        return operTengeAmount;
    }

    public void setOperTengeAmount(BigDecimal operTengeAmount) {
        this.operTengeAmount = operTengeAmount;
    }

    public String getOperReason() {
        return operReason;
    }

    public void setOperReason(String operReason) {
        this.operReason = operReason;
    }

    public Date getOperDocDate() {
        return operDocDate;
    }

    public void setOperDocDate(Date operDocDate) {
        this.operDocDate = operDocDate;
    }

    public String getOperDocNumber() {
        return operDocNumber;
    }

    public void setOperDocNumber(String operDocNumber) {
        this.operDocNumber = operDocNumber;
    }

    public String getSuspFirst() {
        return suspFirst;
    }

    public void setSuspFirst(String suspFirst) {
        this.suspFirst = suspFirst;
    }

    public String getSuspSecond() {
        return suspSecond;
    }

    public void setSuspSecond(String suspSecond) {
        this.suspSecond = suspSecond;
    }

    public String getSuspThird() {
        return suspThird;
    }

    public void setSuspThird(String suspThird) {
        this.suspThird = suspThird;
    }

    public String getOperDopInfo() {
        return operDopInfo;
    }

    public void setOperDopInfo(String operDopInfo) {
        this.operDopInfo = operDopInfo;
    }

    public BigDecimal getMemberId() {
        return memberId;
    }

    public void setMemberId(BigDecimal memberId) {
        this.memberId = memberId;
    }

    public String getMemberVid() {
        return memberVid;
    }

    public void setMemberVid(String memberVid) {
        this.memberVid = memberVid;
    }

    public BigDecimal getMemberResidence() {
        return memberResidence;
    }

    public void setMemberResidence(BigDecimal memberResidence) {
        this.memberResidence = memberResidence;
    }

    public BigDecimal getMemberResidenceCountrycode() {
        return memberResidenceCountrycode;
    }

    public void setMemberResidenceCountrycode(BigDecimal memberResidenceCountrycode) {
        this.memberResidenceCountrycode = memberResidenceCountrycode;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getMemberForeign() {
        return memberForeign;
    }

    public void setMemberForeign(String memberForeign) {
        this.memberForeign = memberForeign;
    }

    public String getMemberBankCode() {
        return memberBankCode;
    }

    public void setMemberBankCode(String memberBankCode) {
        this.memberBankCode = memberBankCode;
    }

    public String getMemberBankName() {
        return memberBankName;
    }

    public void setMemberBankName(String memberBankName) {
        this.memberBankName = memberBankName;
    }

    public String getMemberBankAccount() {
        return memberBankAccount;
    }

    public void setMemberBankAccount(String memberBankAccount) {
        this.memberBankAccount = memberBankAccount;
    }

    public String getMemberBankAddress() {
        return memberBankAddress;
    }

    public void setMemberBankAddress(String memberBankAddress) {
        this.memberBankAddress = memberBankAddress;
    }

    public String getMemberUrName() {
        return memberUrName;
    }

    public void setMemberUrName(String memberUrName) {
        this.memberUrName = memberUrName;
    }

    public String getMemberUrFistHeadName() {
        return memberUrFistHeadName;
    }

    public void setMemberUrFistHeadName(String memberUrFistHeadName) {
        this.memberUrFistHeadName = memberUrFistHeadName;
    }

    public String getMemberOked() {
        return memberOked;
    }

    public void setMemberOked(String memberOked) {
        this.memberOked = memberOked;
    }

    public String getMemberMaincode() {
        return memberMaincode;
    }

    public void setMemberMaincode(String memberMaincode) {
        this.memberMaincode = memberMaincode;
    }

    public String getMemberAcFirstName() {
        return memberAcFirstName;
    }

    public void setMemberAcFirstName(String memberAcFirstName) {
        this.memberAcFirstName = memberAcFirstName;
    }

    public String getMemberAcSecondName() {
        return memberAcSecondName;
    }

    public void setMemberAcSecondName(String memberAcSecondName) {
        this.memberAcSecondName = memberAcSecondName;
    }

    public String getMemberAcMiddlename() {
        return memberAcMiddlename;
    }

    public void setMemberAcMiddlename(String memberAcMiddlename) {
        this.memberAcMiddlename = memberAcMiddlename;
    }

    public String getMemberAcDocType() {
        return memberAcDocType;
    }

    public void setMemberAcDocType(String memberAcDocType) {
        this.memberAcDocType = memberAcDocType;
    }

    public String getMemberAcDocSeries() {
        return memberAcDocSeries;
    }

    public void setMemberAcDocSeries(String memberAcDocSeries) {
        this.memberAcDocSeries = memberAcDocSeries;
    }

    public String getMemberAcDocWhom() {
        return memberAcDocWhom;
    }

    public void setMemberAcDocWhom(String memberAcDocWhom) {
        this.memberAcDocWhom = memberAcDocWhom;
    }

    public Date getMemberAcDocDate() {
        return memberAcDocDate;
    }

    public void setMemberAcDocDate(Date memberAcDocDate) {
        this.memberAcDocDate = memberAcDocDate;
    }

    public Date getMemberAcBirthDate() {
        return memberAcBirthDate;
    }

    public void setMemberAcBirthDate(Date memberAcBirthDate) {
        this.memberAcBirthDate = memberAcBirthDate;
    }

    public String getMemberAcBirthPlace() {
        return memberAcBirthPlace;
    }

    public void setMemberAcBirthPlace(String memberAcBirthPlace) {
        this.memberAcBirthPlace = memberAcBirthPlace;
    }

    public String getMemberRegArea() {
        return memberRegArea;
    }

    public void setMemberRegArea(String memberRegArea) {
        this.memberRegArea = memberRegArea;
    }

    public String getMemberRegRegion() {
        return memberRegRegion;
    }

    public void setMemberRegRegion(String memberRegRegion) {
        this.memberRegRegion = memberRegRegion;
    }

    public String getMemberRegSity() {
        return memberRegSity;
    }

    public void setMemberRegSity(String memberRegSity) {
        this.memberRegSity = memberRegSity;
    }

    public String getMemberRegStreet() {
        return memberRegStreet;
    }

    public void setMemberRegStreet(String memberRegStreet) {
        this.memberRegStreet = memberRegStreet;
    }

    public String getMemberRegHouse() {
        return memberRegHouse;
    }

    public void setMemberRegHouse(String memberRegHouse) {
        this.memberRegHouse = memberRegHouse;
    }

    public String getMemberRegOffice() {
        return memberRegOffice;
    }

    public void setMemberRegOffice(String memberRegOffice) {
        this.memberRegOffice = memberRegOffice;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberSeatArea() {
        return memberSeatArea;
    }

    public void setMemberSeatArea(String memberSeatArea) {
        this.memberSeatArea = memberSeatArea;
    }

    public String getMemberSeatRegion() {
        return memberSeatRegion;
    }

    public void setMemberSeatRegion(String memberSeatRegion) {
        this.memberSeatRegion = memberSeatRegion;
    }

    public String getMemberSeatSity() {
        return memberSeatSity;
    }

    public void setMemberSeatSity(String memberSeatSity) {
        this.memberSeatSity = memberSeatSity;
    }

    public String getMemberSeatStreet() {
        return memberSeatStreet;
    }

    public void setMemberSeatStreet(String memberSeatStreet) {
        this.memberSeatStreet = memberSeatStreet;
    }

    public String getMemberSeatHouse() {
        return memberSeatHouse;
    }

    public void setMemberSeatHouse(String memberSeatHouse) {
        this.memberSeatHouse = memberSeatHouse;
    }

    public String getMemberSeatOffice() {
        return memberSeatOffice;
    }

    public void setMemberSeatOffice(String memberSeatOffice) {
        this.memberSeatOffice = memberSeatOffice;
    }




}
