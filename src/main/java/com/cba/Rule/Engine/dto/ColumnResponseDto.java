package com.cba.Rule.Engine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ColumnResponseDto {

    private Integer id;
    private String columnName;
    private Integer dataType;
}
