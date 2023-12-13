package com.cba.Rule.Engine.repository;

import com.cba.Rule.Engine.model.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Integer> {

    void deleteByRuleId(Integer id);
}
