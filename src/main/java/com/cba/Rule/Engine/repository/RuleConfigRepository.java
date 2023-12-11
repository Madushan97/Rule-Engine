package com.cba.Rule.Engine.repository;

import com.cba.Rule.Engine.model.RuleConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleConfigRepository extends JpaRepository<RuleConfiguration, Integer> {

    void deleteByRuleId(Integer id);
}
