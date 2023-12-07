package com.cba.Rule.Engine.service.impl;

import com.cba.Rule.Engine.dto.RuleResponseDto;
import com.cba.Rule.Engine.dto.requestDto.OperatorRequestDto;
import com.cba.Rule.Engine.dto.requestDto.RuleConfigurationRequestDto;
import com.cba.Rule.Engine.dto.requestDto.RuleRequestDto;
import com.cba.Rule.Engine.model.Operator;
import com.cba.Rule.Engine.model.Rule;
import com.cba.Rule.Engine.model.RuleConfiguration;
import com.cba.Rule.Engine.repository.RuleRepository;
import com.cba.Rule.Engine.service.RuleService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RuleServiceImpl implements RuleService {

    private final ModelMapper modelMapper;
    private final RuleRepository ruleRepository;
    private final EntityManager entityManager;

    @Override
    public RuleResponseDto createRule(@RequestBody RuleRequestDto ruleRequestDto) {
        Rule rule = new Rule();
        rule.setRuleName(ruleRequestDto.getRuleName());
        rule.setTriggerType(ruleRequestDto.getTriggerType());
        rule.setRuleDescription(ruleRequestDto.getRuleDescription());

        // Fetch or create RuleConfig entities
        List<RuleConfiguration> ruleConfigList = new ArrayList<>();
        for (RuleConfigurationRequestDto configDto : ruleRequestDto.getRuleConfig()) {
            RuleConfiguration ruleConfig = entityManager.find(RuleConfiguration.class, configDto.getId());
            if (ruleConfig == null) {
                // Create a new RuleConfiguration if not found
                ruleConfig = new RuleConfiguration();
//                TODO : other attributes
//                ruleConfig.setTableId(configDto.getTableId());
//                ruleConfig.setColumnId();
//                ruleConfig.setAction();
//                ruleConfig.setValue();
//                ruleConfig.setRule();
            }
            ruleConfigList.add(ruleConfig);
        }
        rule.setRuleConfig(ruleConfigList);

        // Fetch or create Operator entities
        List<Operator> operatorList = new ArrayList<>();
        for (OperatorRequestDto operatorDto : ruleRequestDto.getOperator()) {
            Operator operator = entityManager.find(Operator.class, operatorDto.getId());
            if (operator == null) {
                // Create a new Operator if not found
                operator = new Operator();
//                TODO : other attributes
            }
            operatorList.add(operator);
        }
        rule.setOperator(operatorList);

        ruleRepository.save(rule);
        return null;
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
