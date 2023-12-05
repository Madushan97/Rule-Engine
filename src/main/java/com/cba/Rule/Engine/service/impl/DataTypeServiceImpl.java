package com.cba.Rule.Engine.service.impl;

import com.cba.Rule.Engine.dto.DataTypesResponseDto;
import com.cba.Rule.Engine.dto.requestDto.DataTypeRequestDto;
import com.cba.Rule.Engine.model.CardLabel;
import com.cba.Rule.Engine.model.ColumnList;
import com.cba.Rule.Engine.model.DataType;
import com.cba.Rule.Engine.model.PaymentMethods;
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
            List<DataType> dataTypeList = dataTypeRepository.findAll();
            List<DataTypesResponseDto> dataTypesResponseDtos = new ArrayList<>();
            for(DataType dataType : dataTypeList) {
                DataTypesResponseDto dataTypesResponseDto = modelMapper.map(dataType, DataTypesResponseDto.class);
                dataTypesResponseDtos.add(dataTypesResponseDto);
            }
            return dataTypesResponseDtos;
    }

    @Override
    public DataTypesResponseDto createDataType(DataType dataType) {
            DataType dataType1 = new DataType();
            dataType1.setType(dataType.getType());
            dataType1.setCardLabel(dataType.getCardLabel());
            dataType1.setPaymentMethods(dataType.getPaymentMethods());
            dataType1.setColumnList(dataType.getColumnList());
            dataTypeRepository.save(dataType1);
            return modelMapper.map(dataType1, DataTypesResponseDto.class);
    }
}
