package com.cba.Rule.Engine.service;

import com.cba.Rule.Engine.dto.RuleResponseDto;
import com.cba.Rule.Engine.model.Rule;

import java.util.List;

public interface RuleService {

    RuleResponseDto createRule(Rule rule);

    List<RuleResponseDto> getAllRules();

}
