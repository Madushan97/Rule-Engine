package com.cba.Rule.Engine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TableResponseDto {

    private Integer id;
    private String tableName;
    private List<ColumnResponseDto> columnList;
}
