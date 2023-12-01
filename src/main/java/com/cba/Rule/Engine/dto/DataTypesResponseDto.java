package com.cba.Rule.Engine.dto;

import jakarta.persistence.EnumType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DataTypesResponseDto {

    private Integer id;
    private EnumType type;
}
