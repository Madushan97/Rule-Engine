package com.cba.Rule.Engine.service.impl;

import com.cba.Rule.Engine.dto.RuleResponseDto;
import com.cba.Rule.Engine.model.Rule;
import com.cba.Rule.Engine.repository.RuleRepository;
import com.cba.Rule.Engine.service.RuleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RuleServiceImpl implements RuleService {

    private final ModelMapper modelMapper;
    private final RuleRepository ruleRepository;

    @Override
    public RuleResponseDto createRule(Rule rule) {
        return modelMapper.map(rule, RuleResponseDto.class);
    }

    @Override
    public List<RuleResponseDto> getAllRules() {
        List<Rule> ruleList = ruleRepository.findAll();
        List<RuleResponseDto> ruleResponseDtoList = new ArrayList<>();
        for (Rule rule : ruleList) {
            RuleResponseDto ruleResponseDto = modelMapper.map(rule, RuleResponseDto.class);
            ruleResponseDtoList.add(ruleResponseDto);
        }
        return ruleResponseDtoList;
    }
}
