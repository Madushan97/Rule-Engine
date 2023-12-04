package com.cba.Rule.Engine.repository;

import com.cba.Rule.Engine.model.DataType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataTypeRepository extends JpaRepository<DataType, Integer> {

}
