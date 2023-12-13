package com.cba.Rule.Engine.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class OperatorRequestDto {

    private Integer id;
    private String operator;
    private RuleRequestDto ruleRequestDto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public RuleRequestDto getRuleRequestDto() {
        return ruleRequestDto;
    }

    public void setRuleRequestDto(RuleRequestDto ruleRequestDto) {
        this.ruleRequestDto = ruleRequestDto;
    }
}
