package com.cba.Rule.Engine.service.impl;

import com.cba.Rule.Engine.dto.RuleResponseDto;
import com.cba.Rule.Engine.dto.requestDto.OperatorRequestDto;
import com.cba.Rule.Engine.dto.requestDto.RuleConfigurationRequestDto;
import com.cba.Rule.Engine.dto.requestDto.RuleRequestDto;
import com.cba.Rule.Engine.exception.NotFoundException;
import com.cba.Rule.Engine.model.*;
import com.cba.Rule.Engine.repository.OperatorRepository;
import com.cba.Rule.Engine.repository.RuleConfigRepository;
import com.cba.Rule.Engine.repository.RuleRepository;
import com.cba.Rule.Engine.service.RuleService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RuleServiceImpl implements RuleService {

    private final ModelMapper modelMapper;
    private final RuleRepository ruleRepository;
    private final RuleConfigRepository ruleConfigRepository;
    private final OperatorRepository operatorRepository;

    @Override
    public RuleResponseDto createRule(RuleRequestDto ruleRequestDto) {
        Rule rule = new Rule();
        rule.setRuleName(ruleRequestDto.getRuleName());
        rule.setTriggerType(ruleRequestDto.getTriggerType());
        rule.setRuleDescription(ruleRequestDto.getRuleDescription());

        // Create RuleConfig entities
        List<RuleConfiguration> ruleConfigList = new ArrayList<>();
        for (RuleConfigurationRequestDto configDto : ruleRequestDto.getRuleConfig()) {
            RuleConfiguration ruleConfig = createOrUpdateRuleConfiguration(configDto, rule);
            ruleConfigList.add(ruleConfig);
        }
        rule.setRuleConfig(ruleConfigList);

        // Create Operator entities
        List<Operator> operatorList = new ArrayList<>();
        for (OperatorRequestDto operatorDto : ruleRequestDto.getOperator()) {
            Operator operator = createOrUpdateOperator(operatorDto, rule);
            operatorList.add(operator);
        }
        rule.setOperator(operatorList);

        Rule savedRule = ruleRepository.save(rule);
        return modelMapper.map(savedRule, RuleResponseDto.class);
    }

    private RuleConfiguration createOrUpdateRuleConfiguration(RuleConfigurationRequestDto configDto, Rule rule) {
        RuleConfiguration ruleConfig = new RuleConfiguration();

        ruleConfig.setId(configDto.getId());
        ruleConfig.setAction(configDto.getAction());
        ruleConfig.setValue(configDto.getValue());

        // Save the Rule entity if it's not saved yet
        if (rule.getId() == null) {
            rule = ruleRepository.save(rule);
        }

        ruleConfig.setRule(rule);

        if (configDto.getTableId() != null) {
            ruleConfig.setTableId(modelMapper.map(configDto.getTableId(), TableStructure.class));
        }

        if (configDto.getColumnId() != null) {
            ruleConfig.setColumnId(modelMapper.map(configDto.getColumnId(), ColumnList.class));
        }
        return ruleConfigRepository.save(ruleConfig);
    }

    private Operator createOrUpdateOperator(OperatorRequestDto operatorDto, Rule rule) {
        Operator operator = new Operator();
        operator.setId(operatorDto.getId());
        operator.setOperator(operatorDto.getOperator());
        operator.setRule(rule);

        return operatorRepository.save(operator);
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

    @Override
    public String deleteRule(int id) {
        ruleRepository.deleteById(id);
        return "Delete Successfully";
    }

    @Override
    public RuleResponseDto updateRule(int id, RuleRequestDto ruleRequestDto) {

        Rule rule = ruleRepository.findById(id).orElseThrow(() -> new NotFoundException("Rule not found with id: " + id));

        // Update fields with the new data
        rule.setRuleName(ruleRequestDto.getRuleName());
        rule.setTriggerType(ruleRequestDto.getTriggerType());
        rule.setRuleDescription(ruleRequestDto.getRuleDescription());

        updateRuleConfigurations(ruleRequestDto.getRuleConfig(), rule);
        updateOperators(ruleRequestDto.getOperator(), rule);

        Rule updatedRule = ruleRepository.save(rule);
        return modelMapper.map(updatedRule, RuleResponseDto.class);
    }

    private void updateRuleConfigurations(List<RuleConfigurationRequestDto> ruleConfigDtos, Rule rule) {

        List<RuleConfiguration> existingRuleConfigs = rule.getRuleConfig();

        for (RuleConfigurationRequestDto configDto : ruleConfigDtos) {
            RuleConfiguration existingRuleConfig = findExistingRuleConfig(configDto, existingRuleConfigs);

            if (existingRuleConfig != null) {
                updateExistingRuleConfig(existingRuleConfig, configDto);
            } else {
                RuleConfiguration newRuleConfig = createOrUpdateRuleConfiguration(configDto, rule);
                existingRuleConfigs.add(newRuleConfig);
            }
        }
    }

    private RuleConfiguration findExistingRuleConfig(RuleConfigurationRequestDto configDto, List<RuleConfiguration> existingRuleConfigs) {
        return existingRuleConfigs.stream()
                .filter(ruleConfig -> ruleConfig.getId().equals(configDto.getId()))
                .findFirst()
                .orElse(null);
    }

    private void updateExistingRuleConfig(RuleConfiguration existingRuleConfig, RuleConfigurationRequestDto configDto) {
        existingRuleConfig.setRule(configDto.getRule() != null ? modelMapper.map(configDto.getRule(), Rule.class) : null);
        existingRuleConfig.setAction(configDto.getAction());
        existingRuleConfig.setColumnId(configDto.getColumnId() != null ? modelMapper.map(configDto.getColumnId(), ColumnList.class) : null);
        existingRuleConfig.setValue(configDto.getValue());
        existingRuleConfig.setTableId(configDto.getTableId() != null ? modelMapper.map(configDto.getTableId(), TableStructure.class) : null);
    }

    private void updateOperators(List<OperatorRequestDto> operatorDtos, Rule rule) {
        // Get the existing operators
        List<Operator> existingOperators = rule.getOperator();

        // Update existing operators and add new ones
        for (OperatorRequestDto operatorDto : operatorDtos) {
            Operator existingOperator = findExistingOperator(operatorDto, existingOperators);

            if (existingOperator != null) {
                updateExistingOperator(existingOperator, operatorDto);
            }
//            else {
//                Operator newOperator = createOrUpdateOperator(operatorDto, rule);
//                existingOperators.add(newOperator);
//            }
        }
    }

    private Operator findExistingOperator(OperatorRequestDto operatorDto, List<Operator> existingOperators) {
        for (Operator existingOperator : existingOperators) {
            if (Objects.equals(existingOperator.getId(), operatorDto.getId())) {
                return existingOperator;
            }
        }
        return null;
    }

    private void updateExistingOperator(Operator existingOperator, OperatorRequestDto operatorDto) {
        existingOperator.setOperator(operatorDto.getOperator());
        existingOperator.setRule(modelMapper.map(operatorDto.getRuleRequestDto(), Rule.class));
        existingOperator.setId(operatorDto.getId());
    }
}
