package com.cba.Rule.Engine.service;

import com.cba.Rule.Engine.dto.RuleResponseDto;
import com.cba.Rule.Engine.dto.requestDto.RuleRequestDto;
import com.cba.Rule.Engine.model.Rule;

import java.util.List;

public interface RuleService {

    RuleResponseDto createRule(RuleRequestDto ruleRequestDto);

    List<RuleResponseDto> getAllRules();

    String deleteRule(int id);

    RuleResponseDto updateRule(int id, RuleRequestDto ruleRequestDto);
}
