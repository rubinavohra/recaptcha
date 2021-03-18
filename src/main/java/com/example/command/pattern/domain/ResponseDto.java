
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
    "memberId",
    "firstName",
    "lastName",
    "memberJoinDate",
    "memberIds",
    "rewardsTotal",
    "rewardsTotalLabel",
    "rewards"
})
public class ResponseDto {

    @JsonProperty("memberId")
    private String memberId;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("memberJoinDate")
    private String memberJoinDate;
    @JsonProperty("memberIds")
    private List<Integer> memberIds = null;
    @JsonProperty("rewardsTotal")
    private Double rewardsTotal;
    @JsonProperty("rewardsTotalLabel")
    private String rewardsTotalLabel;
    @JsonProperty("rewards")
    private List<Reward> rewards = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("memberId")
    public String getMemberId() {
        return memberId;
    }

    @JsonProperty("memberId")
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("memberJoinDate")
    public String getMemberJoinDate() {
        return memberJoinDate;
    }

    @JsonProperty("memberJoinDate")
    public void setMemberJoinDate(String memberJoinDate) {
        this.memberJoinDate = memberJoinDate;
    }

    @JsonProperty("memberIds")
    public List<Integer> getMemberIds() {
        return memberIds;
    }

    @JsonProperty("memberIds")
    public void setMemberIds(List<Integer> memberIds) {
        this.memberIds = memberIds;
    }

    @JsonProperty("rewardsTotal")
    public Double getRewardsTotal() {
        return rewardsTotal;
    }

    @JsonProperty("rewardsTotal")
    public void setRewardsTotal(Double rewardsTotal) {
        this.rewardsTotal = rewardsTotal;
    }

    @JsonProperty("rewardsTotalLabel")
    public String getRewardsTotalLabel() {
        return rewardsTotalLabel;
    }

    @JsonProperty("rewardsTotalLabel")
    public void setRewardsTotalLabel(String rewardsTotalLabel) {
        this.rewardsTotalLabel = rewardsTotalLabel;
    }

    @JsonProperty("rewards")
    public List<Reward> getRewards() {
        return rewards;
    }

    @JsonProperty("rewards")
    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
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
        return "ResponseDto{" +
                "memberId='" + memberId + '\'' +
                ", rewardsTotal=" + rewardsTotal +
                ", rewards=" + rewards +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
