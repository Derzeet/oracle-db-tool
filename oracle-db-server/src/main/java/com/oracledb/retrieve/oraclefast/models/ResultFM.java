package com.oracledb.retrieve.oraclefast.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.cglib.core.Local;

import java.util.Date;

@Entity
@Table(name = "RESULT_FM", schema = "KFM")
public class ResultFM {
    @Id
    @Nullable
    @Column(name = "mess_ofm_id")
    private Long messOfmId;

    @Nullable
    @Column(name = "mess_number")
    private Long messNumber;

    @Nullable
    @Column(name = "mess_date")
    private Date messDate;

    @Nullable
    @Column(name = "mess_type")
    private String messType;

    @Nullable
    @Column(name = "oper_status")
    private String operStatus;

    @Nullable
    @Column(name = "mess_reason")
    private String messReason;

    @Nullable
    @Column(name = "cfm_code")
    private Long cfmCode;

    @Nullable
    @Column(name = "cfm_name")
    private String cfmName;

    @Column(name = "cfm_maincode")
    private String cfmMainCode;

    @Nullable
    @Column(name = "cfm_seat_area")
    private String cfmSeatArea;

    @Nullable
    @Column(name = "cfm_seat_region")
    private String cfmSeatRegion;

    @Nullable
    @Column(name = "cfm_seat_sity")
    private String cfmSeatCity;

    @Nullable
    @Column(name = "cfm_seat_street")
    private String cfmSeatStreet;

    @Nullable
    @Column(name = "cfm_seat_house")
    private String cfmSeatHouse;

    @Nullable
    @Column(name = "cfm_seat_office")
    private String cfmSeatOffice;

    @Nullable
    @Column(name = "cfm_seat_postcode")
    private String cfmSeatPostcode;

    @Nullable
    @Column(name = "cfm_isac")
    private Long cfmIsac;

    @Nullable
    @Column(name = "doc_type")
    private String docType;

    @Nullable
    @Column(name = "cfm_doc_number")
    private String cfmDocNumber;

    @Nullable
    @Column(name = "cfm_doc_series")
    private String cfmDocSeries;

    @Nullable
    @Column(name = "cfm_doc_whom")
    private String cfmDocWhom;

    @Nullable
    @Column(name = "cfm_doc_date")
    private Date cfmDocDate;

    @Nullable
    @Column(name = "oper_number")
    private String operNumber;

    @Nullable
    @Column(name = "oper_type")
    private String operType;

    @Nullable
    @Column(name = "назначение платежа")
    private String operPaymentPurpose;

    @Nullable
    @Column(name = "oper_members_count")
    private Long operMembersCount;

    @Nullable
    @Column(name = "currency_type")
    private String currencyType;

    @Nullable
    @Column(name = "oper_currency_amount")
    private Long operCurrencyAmount;

    @Nullable
    @Column(name = "oper_tenge_amount")
    private Long operTengeAmount;

    @Nullable
    @Column(name = "oper_reason")
    private String operReason;

    @Nullable
    @Column(name = "oper_doc_date")
    private Date operDocDate;

    @Nullable
    @Column(name = "oper_doc_number")
    private String operDocNumber;

    @Nullable
    @Column(name = "susp_first")
    private String suspFirst;

    @Nullable
    @Column(name = "susp_second")
    private String suspSecond;

    @Nullable
    @Column(name = "susp_third")
    private String suspThird;

    @Nullable
    @Column(name = "oper_dopinfo")
    private String operDopInfo;

    @Nullable
    @Column(name = "member_id")
    private Long memberId;

    @Nullable
    @Column(name = "member_vid")
    private String memberVid;

    @Nullable
    @Column(name = "member_residence")
    private Long memberResidence;

    @Nullable
    @Column(name = "member_residence_countrycode")
    private Long memberResidenceCountrycode;

    @Nullable
    @Column(name = "member_type")
    private String memberType;

    @Nullable
    @Column(name = "member_foreign")
    private String memberForeign;

    @Nullable
    @Column(name = "member_bank_code")
    private String memberBankCode;

    @Nullable
    @Column(name = "member_bank_name")
    private String memberBankName;

    @Nullable
    @Column(name = "member_bank_account")
    private String memberBankAccount;

    @Nullable
    @Column(name = "member_bank_address")
    private String memberBankAddress;

    @Nullable
    @Column(name = "member_ur_name")
    private String memberUrName;

    @Nullable
    @Column(name = "member_ur_fisthead_name")
    private String memberUrFistHeadName;

    @Nullable
    @Column(name = "member_oked")
    private String memberOked;

    @Nullable
    @Column(name = "member_maincode")
    private String memberMaincode;

    @Nullable
    @Column(name = "member_ac_firstname")
    private String memberAcFirstName;

    @Nullable
    @Column(name = "member_ac_secondname")
    private String memberAcSecondName;

    @Nullable
    @Column(name = "member_ac_middlename")
    private String memberAcMiddlename;

    @Nullable
    @Column(name = "member_ac_doc_type")
    private String memberAcDocType;

    @Nullable
    @Column(name = "member_ac_doc_series")
    private String memberAcDocSeries;

    @Nullable
    @Column(name = "member_ac_doc_whom")
    private String memberAcDocWhom;

    @Nullable
    @Column(name = "member_ac_doc_date")
    private Date memberAcDocDate;

    @Nullable
    @Column(name = "member_ac_birth_date")
    private Date memberAcBirthDate;

    @Nullable
    @Column(name = "member_ac_birth_place")
    private String memberAcBirthPlace;

    @Nullable
    @Column(name = "member_reg_area")
    private String memberRegArea;

    @Nullable
    @Column(name = "member_reg_region")
    private String memberRegRegion;

    @Nullable
    @Column(name = "member_reg_sity")
    private String memberRegSity;

    @Nullable
    @Column(name = "member_reg_street")
    private String memberRegStreet;

    @Nullable
    @Column(name = "member_reg_house")
    private String memberRegHouse;

    @Nullable
    @Column(name = "member_reg_office")
    private String memberRegOffice;

    @Nullable
    @Column(name = "member_phone")
    private String memberPhone;

    @Nullable
    @Column(name = "member_email")
    private String memberEmail;

    @Nullable
    @Column(name = "member_seat_area")
    private String memberSeatArea;

    @Nullable
    @Column(name = "member_seat_region")
    private String memberSeatRegion;

    @Nullable
    @Column(name = "member_seat_sity")
    private String memberSeatSity;

    @Nullable
    @Column(name = "member_seat_street")
    private String memberSeatStreet;

    @Nullable
    @Column(name = "member_seat_house")
    private String memberSeatHouse;

    @Nullable
    @Column(name = "member_seat_office")
    private String memberSeatOffice;

    public Long getMessOfmId() {
        return messOfmId;
    }

    public void setMessOfmId(Long messOfmId) {
        this.messOfmId = messOfmId;
    }

    public Long getMessNumber() {
        return messNumber;
    }

    public void setMessNumber(Long messNumber) {
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

    public Long getCfmCode() {
        return cfmCode;
    }

    public void setCfmCode(Long cfmCode) {
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

    public Long getCfmIsac() {
        return cfmIsac;
    }

    public void setCfmIsac(Long cfmIsac) {
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

    public Long getOperMembersCount() {
        return operMembersCount;
    }

    public void setOperMembersCount(Long operMembersCount) {
        this.operMembersCount = operMembersCount;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public Long getOperCurrencyAmount() {
        return operCurrencyAmount;
    }

    public void setOperCurrencyAmount(Long operCurrencyAmount) {
        this.operCurrencyAmount = operCurrencyAmount;
    }

    public Long getOperTengeAmount() {
        return operTengeAmount;
    }

    public void setOperTengeAmount(Long operTengeAmount) {
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

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberVid() {
        return memberVid;
    }

    public void setMemberVid(String memberVid) {
        this.memberVid = memberVid;
    }

    public Long getMemberResidence() {
        return memberResidence;
    }

    public void setMemberResidence(Long memberResidence) {
        this.memberResidence = memberResidence;
    }

    public Long getMemberResidenceCountrycode() {
        return memberResidenceCountrycode;
    }

    public void setMemberResidenceCountrycode(Long memberResidenceCountrycode) {
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
