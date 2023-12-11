package com.cba.Rule.Engine.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "rule")
@AllArgsConstructor
@NoArgsConstructor
public class Rule {

    private Integer id;
    private String ruleName;
    private String triggerType;
    private String ruleDescription;
    private List<RuleConfiguration> ruleConfig;
    private List<Operator> operator;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 50)
    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    @Column(name = "trigger_type", nullable = false, length = 50)
    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    @Column(name = "description", nullable = false, length = 100)
    public String getRuleDescription() {
        return ruleDescription;
    }

    public void setRuleDescription(String ruleDescription) {
        this.ruleDescription = ruleDescription;
    }

    @OneToMany(mappedBy = "rule", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<RuleConfiguration> getRuleConfig() {
        return ruleConfig;
    }

    public void setRuleConfig(List<RuleConfiguration> ruleConfig) {
        this.ruleConfig = ruleConfig;
    }

    @OneToMany(mappedBy = "rule", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Operator> getOperator() {
        return operator;
    }

    public void setOperator(List<Operator> operator) {
        this.operator = operator;
    }

}
