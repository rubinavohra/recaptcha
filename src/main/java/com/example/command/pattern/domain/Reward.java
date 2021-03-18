
package com.example.command.pattern.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "balance",
    "rewardYear",
    "issuedYear",
    "expirationDate",
    "eligible",
    "breakdowns"
})
public class Reward {
    public Reward(Double balance, Integer rewardYear, Integer issuedYear, String expirationDate, Boolean eligible, List<Breakdown> breakdowns) {
        this.balance = balance;
        this.rewardYear = rewardYear;
        this.issuedYear = issuedYear;
        this.expirationDate = expirationDate;
        this.eligible = eligible;
        this.breakdowns = breakdowns;
       // this.additionalProperties = additionalProperties;
    }

    @JsonProperty("balance")
    private Double balance;
    @JsonProperty("rewardYear")
    private Integer rewardYear;
    @JsonProperty("issuedYear")
    private Integer issuedYear;
    @JsonProperty("expirationDate")
    private String expirationDate;
    @JsonProperty("eligible")
    private Boolean eligible;
    @JsonProperty("breakdowns")
    private List<Breakdown> breakdowns = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("balance")
    public Double getBalance() {
        return balance;
    }

    @JsonProperty("balance")
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @JsonProperty("rewardYear")
    public Integer getRewardYear() {
        return rewardYear;
    }

    @JsonProperty("rewardYear")
    public void setRewardYear(Integer rewardYear) {
        this.rewardYear = rewardYear;
    }

    @JsonProperty("issuedYear")
    public Integer getIssuedYear() {
        return issuedYear;
    }

    @JsonProperty("issuedYear")
    public void setIssuedYear(Integer issuedYear) {
        this.issuedYear = issuedYear;
    }

    @JsonProperty("expirationDate")
    public String getExpirationDate() {
        return expirationDate;
    }

    @JsonProperty("expirationDate")
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @JsonProperty("eligible")
    public Boolean getEligible() {
        return eligible;
    }

    @JsonProperty("eligible")
    public void setEligible(Boolean eligible) {
        this.eligible = eligible;
    }

    @JsonProperty("breakdowns")
    public List<Breakdown> getBreakdowns() {
        return breakdowns;
    }

    @JsonProperty("breakdowns")
    public void setBreakdowns(List<Breakdown> breakdowns) {
        this.breakdowns = breakdowns;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Reward{" +
                "balance=" + balance +
                ", rewardYear=" + rewardYear +
                ", issuedYear=" + issuedYear +
                ", expirationDate='" + expirationDate + '\'' +
                ", eligible=" + eligible +
                ", breakdowns=" + breakdowns +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
