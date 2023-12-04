package com.cba.Rule.Engine.service.impl;

import com.cba.Rule.Engine.dto.DataTypesResponseDto;
import com.cba.Rule.Engine.model.DataType;
import com.cba.Rule.Engine.repository.DataTypeRepository;
import com.cba.Rule.Engine.service.DataTypeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataTypeServiceImpl implements DataTypeService {

    private final DataTypeRepository dataTypeRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<DataTypesResponseDto> getAllDataTypes() {
        try {
            List<DataType> dataTypeList = dataTypeRepository.findAll();
            List<DataTypesResponseDto> dataTypesResponseDtos = new ArrayList<>();
            for(DataType dataType : dataTypeList) {
                DataTypesResponseDto dataTypesResponseDto = modelMapper.map(dataType, DataTypesResponseDto.class);
                dataTypesResponseDtos.add(dataTypesResponseDto);
            }
            return dataTypesResponseDtos;
        } catch (Exception e) {
            throw e;
        }
    }
}
