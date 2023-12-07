package com.cba.Rule.Engine.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class TableStructureRequestDto {

    private Integer id;
    private String tableName;
    private List<ColumnListRequestDto> columnList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ColumnListRequestDto> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<ColumnListRequestDto> columnList) {
        this.columnList = columnList;
    }
}
