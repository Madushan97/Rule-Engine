package com.cba.Rule.Engine.service.impl;

import com.cba.Rule.Engine.dto.DataTypesResponseDto;
import com.cba.Rule.Engine.dto.requestDto.*;
import com.cba.Rule.Engine.model.*;
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
    public DataTypesResponseDto createDataType(DataTypeRequestDto dataTypeRequestDto) {
        DataType dataType1 = new DataType();
        dataType1.setType(dataTypeRequestDto.getType());

        // Set CardLabel if not null
        if (dataTypeRequestDto.getCardLabel() != null) {
            List<CardLabel> cardLabelList = new ArrayList<>();
            for (CardLabelRequestDto cardLabelRequestDto : dataTypeRequestDto.getCardLabel()) {
                CardLabel cardLabel = createOrUpdateCardList(cardLabelRequestDto);
                cardLabelList.add(cardLabel);
            }
            dataType1.setCardLabel(cardLabelList);
        }

        // Set PaymentMethods if not null
        if (dataTypeRequestDto.getPaymentMethods() != null) {
            List<PaymentMethods> paymentMethods = new ArrayList<>();
            for (PaymentMethodsRequestDto paymentMethodsRequestDto : dataTypeRequestDto.getPaymentMethods()) {
                PaymentMethods paymentMethods1 = createOrUpdatePaymentMethod(paymentMethodsRequestDto);
                paymentMethods.add(paymentMethods1);
            }
            dataType1.setPaymentMethods(paymentMethods);
        }

        // Set ColumnList if not null
        if (dataTypeRequestDto.getColumnList() != null) {
            List<ColumnList> columnLists = new ArrayList<>();
            for (ColumnListRequestDto columnListRequestDto : dataTypeRequestDto.getColumnList()) {
                ColumnList columnList = createOrUpdateColumnList(columnListRequestDto);
                columnLists.add(columnList);
            }
            dataType1.setColumnList(columnLists);
        }

        dataTypeRepository.save(dataType1);
        return modelMapper.map(dataType1, DataTypesResponseDto.class);
    }


    private CardLabel createOrUpdateCardList(CardLabelRequestDto cardLabelRequestDto) {
        CardLabel cardLabel1 = new CardLabel();
        cardLabel1.setId(cardLabelRequestDto.getId());
        cardLabel1.setName(cardLabelRequestDto.getName());
        if (cardLabelRequestDto.getDataType() != null)
            cardLabel1.setDataType(modelMapper.map(cardLabelRequestDto.getDataType(), DataType.class));
        return cardLabel1;
    }

    private PaymentMethods createOrUpdatePaymentMethod(PaymentMethodsRequestDto paymentMethodsRequestDto) {
        PaymentMethods paymentMethods = new PaymentMethods();
        paymentMethods.setId(paymentMethodsRequestDto.getId());
        if (paymentMethodsRequestDto.getDataType() != null)
            paymentMethods.setDataType(modelMapper.map(paymentMethodsRequestDto.getDataType(), DataType.class));
        paymentMethods.setName(paymentMethodsRequestDto.getName());
        return paymentMethods;
    }

    private ColumnList createOrUpdateColumnList(ColumnListRequestDto columnListRequestDto) {
        ColumnList columnList = new ColumnList();
        columnList.setId(columnListRequestDto.getId());
        columnList.setColumnName(columnListRequestDto.getColumnName());
        if (columnListRequestDto.getDataType() != null)
            columnList.setDataType(modelMapper.map(columnListRequestDto.getDataType(), DataType.class));
        if (columnListRequestDto.getTableStructure() != null)
            columnList.setTableStructure(modelMapper.map(columnListRequestDto.getTableStructure(), TableStructure.class));
        return columnList;
    }
}
