package com.example.command.pattern.domain;

public class Requestdto {

    private String searchEmployeeNumber;
    private String searchMemberNumber;
    private String searchOpId;

    public Requestdto(String searchEmployeeNumber, String searchMemberNumber, String searchOpId, String customerType) {
        this.searchEmployeeNumber = searchEmployeeNumber;
        this.searchMemberNumber = searchMemberNumber;
        this.searchOpId = searchOpId;
        this.customerType = customerType;
    }

    public String getSearchEmployeeNumber() {
        return searchEmployeeNumber;
    }

    public void setSearchEmployeeNumber(String searchEmployeeNumber) {
        this.searchEmployeeNumber = searchEmployeeNumber;
    }

    public String getSearchMemberNumber() {
        return searchMemberNumber;
    }

    public void setSearchMemberNumber(String searchMemberNumber) {
        this.searchMemberNumber = searchMemberNumber;
    }

    public String getSearchOpId() {
        return searchOpId;
    }

    public void setSearchOpId(String searchOpId) {
        this.searchOpId = searchOpId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return "Requestdto{" +
                "searchEmployeeNumber='" + searchEmployeeNumber + '\'' +
                ", searchMemberNumber='" + searchMemberNumber + '\'' +
                ", searchOpId='" + searchOpId + '\'' +
                ", customerType='" + customerType + '\'' +
                '}';
    }

    private String customerType;
}
