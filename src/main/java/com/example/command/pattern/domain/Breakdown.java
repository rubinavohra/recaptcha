
package com.example.command.pattern.domain;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "balanceType",
    "balanceTypeLabel",
    "balanceAmount",
    "cashCheckEligible"
})
public class Breakdown {

    public Breakdown(String balanceType, String balanceTypeLabel, Double balanceAmount, Boolean cashCheckEligible) {
        this.balanceType = balanceType;
        this.balanceTypeLabel = balanceTypeLabel;
        this.balanceAmount = balanceAmount;
        this.cashCheckEligible = cashCheckEligible;
        //this.additionalProperties = additionalProperties;
    }

    @JsonProperty("balanceType")
    private String balanceType;
    @JsonProperty("balanceTypeLabel")
    private String balanceTypeLabel;
    @JsonProperty("balanceAmount")
    private Double balanceAmount;
    @JsonProperty("cashCheckEligible")
    private Boolean cashCheckEligible;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("balanceType")
    public String getBalanceType() {
        return balanceType;
    }

    @JsonProperty("balanceType")
    public void setBalanceType(String balanceType) {
        this.balanceType = balanceType;
    }

    @JsonProperty("balanceTypeLabel")
    public String getBalanceTypeLabel() {
        return balanceTypeLabel;
    }

    @JsonProperty("balanceTypeLabel")
    public void setBalanceTypeLabel(String balanceTypeLabel) {
        this.balanceTypeLabel = balanceTypeLabel;
    }

    @JsonProperty("balanceAmount")
    public Double getBalanceAmount() {
        return balanceAmount;
    }

    @JsonProperty("balanceAmount")
    public void setBalanceAmount(Double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    @JsonProperty("cashCheckEligible")
    public Boolean getCashCheckEligible() {
        return cashCheckEligible;
    }

    @JsonProperty("cashCheckEligible")
    public void setCashCheckEligible(Boolean cashCheckEligible) {
        this.cashCheckEligible = cashCheckEligible;
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
        return "Breakdown{" +
                "balanceType='" + balanceType + '\'' +
                ", balanceTypeLabel='" + balanceTypeLabel + '\'' +
                ", balanceAmount=" + balanceAmount +
                ", cashCheckEligible=" + cashCheckEligible +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
