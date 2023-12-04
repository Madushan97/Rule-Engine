package com.cba.Rule.Engine.repository;

import com.cba.Rule.Engine.model.TableStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<TableStructure, Integer> {
}
