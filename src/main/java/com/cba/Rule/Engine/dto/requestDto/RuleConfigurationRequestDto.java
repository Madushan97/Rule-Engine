package com.cba.Rule.Engine.dto.requestDto;

import com.cba.Rule.Engine.model.ColumnList;
import com.cba.Rule.Engine.model.Rule;
import com.cba.Rule.Engine.model.TableStructure;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class RuleConfigurationRequestDto {

    private Integer id;
    private TableStructureRequestDto tableId;
    private ColumnListRequestDto columnId;
    private String action;
    private String value;
    private RuleRequestDto rule;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TableStructureRequestDto getTableId() {
        return tableId;
    }

    public void setTableId(TableStructureRequestDto tableId) {
        this.tableId = tableId;
    }

    public ColumnListRequestDto getColumnId() {
        return columnId;
    }

    public void setColumnId(ColumnListRequestDto columnId) {
        this.columnId = columnId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public RuleRequestDto getRule() {
        return rule;
    }

    public void setRule(RuleRequestDto rule) {
        this.rule = rule;
    }
}
