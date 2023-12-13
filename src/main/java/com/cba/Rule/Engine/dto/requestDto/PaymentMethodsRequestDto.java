package com.cba.Rule.Engine.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethodsRequestDto {

    private Integer id;
    private String name;
    private DataTypeRequestDto dataType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataTypeRequestDto getDataType() {
        return dataType;
    }

    public void setDataType(DataTypeRequestDto dataType) {
        this.dataType = dataType;
    }
}
