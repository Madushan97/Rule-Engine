package com.cba.Rule.Engine.service;

import com.cba.Rule.Engine.dto.DataTypesResponseDto;
import com.cba.Rule.Engine.dto.UserResponseDto;

import java.util.List;

public interface DataTypeService {

    List<DataTypesResponseDto> getAllDataTypes();
}
