package com.cba.Rule.Engine.service;

import com.cba.Rule.Engine.dto.DataTypesResponseDto;
import com.cba.Rule.Engine.dto.UserResponseDto;
import com.cba.Rule.Engine.dto.requestDto.DataTypeRequestDto;
import com.cba.Rule.Engine.model.DataType;

import java.util.List;

public interface DataTypeService {

    List<DataTypesResponseDto> getAllDataTypes();

    DataTypesResponseDto createDataType(DataType dataType);
}
