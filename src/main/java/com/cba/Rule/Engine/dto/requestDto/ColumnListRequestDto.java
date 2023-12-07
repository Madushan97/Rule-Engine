package com.cba.Rule.Engine.dto.requestDto;

import com.cba.Rule.Engine.model.DataType;
import com.cba.Rule.Engine.model.TableStructure;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ColumnListRequestDto {

    private Integer id;
    private String columnName;
    private DataTypeRequestDto dataType;
    private TableStructureRequestDto tableStructure;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public DataTypeRequestDto getDataType() {
        return dataType;
    }

    public void setDataType(DataTypeRequestDto dataType) {
        this.dataType = dataType;
    }

    public TableStructureRequestDto getTableStructure() {
        return tableStructure;
    }

    public void setTableStructure(TableStructureRequestDto tableStructure) {
        this.tableStructure = tableStructure;
    }
}
