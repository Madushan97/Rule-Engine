package com.cba.Rule.Engine.dto;

import com.cba.Rule.Engine.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RuleResponseDto {

//    private Integer id;
    private String ruleName;
    private String triggerType;
    private String ruleDescription;
    private List<RuleConfiguration> ruleConfig;
    private List<Operator> operator;
}
