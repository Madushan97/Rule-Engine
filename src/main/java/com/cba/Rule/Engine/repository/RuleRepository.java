package com.cba.Rule.Engine.repository;

import com.cba.Rule.Engine.model.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleRepository extends JpaRepository<Rule, Integer> {

}
