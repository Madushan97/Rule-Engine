package com.cba.Rule.Engine.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RuleRequestDto {

    private Integer id;
    private String ruleName;
    private String triggerType;
    private String ruleDescription;
    private List<RuleConfigurationRequestDto> ruleConfig;
    private List<OperatorRequestDto> operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    public String getRuleDescription() {
        return ruleDescription;
    }

    public void setRuleDescription(String ruleDescription) {
        this.ruleDescription = ruleDescription;
    }

    public List<RuleConfigurationRequestDto> getRuleConfig() {
        return ruleConfig;
    }

    public void setRuleConfig(List<RuleConfigurationRequestDto> ruleConfig) {
        this.ruleConfig = ruleConfig;
    }

    public List<OperatorRequestDto> getOperator() {
        return operator;
    }

    public void setOperator(List<OperatorRequestDto> operator) {
        this.operator = operator;
    }
}

