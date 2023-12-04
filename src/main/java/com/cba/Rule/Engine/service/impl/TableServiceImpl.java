package com.cba.Rule.Engine.service.impl;

import com.cba.Rule.Engine.dto.ColumnResponseDto;
import com.cba.Rule.Engine.dto.TableResponseDto;
import com.cba.Rule.Engine.model.ColumnList;
import com.cba.Rule.Engine.model.TableStructure;
import com.cba.Rule.Engine.repository.TableRepository;
import com.cba.Rule.Engine.service.TableService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TableServiceImpl implements TableService {

    private final ModelMapper modelMapper;
    private final TableRepository tableRepository;


    @Override
    public List<TableResponseDto> getAllTables() {
        try {
            List<TableStructure> tableList = tableRepository.findAll();
            List<TableResponseDto> dtos = new ArrayList<>();

            for (TableStructure table : tableList) {
                TableResponseDto tableDto = new TableResponseDto();
                tableDto.setId(table.getId());
                tableDto.setTableName(table.getTableName());

                List<ColumnResponseDto> columnListDtos = new ArrayList<>();

                for (ColumnList column : table.getColumnList()) {
                    ColumnResponseDto columnDto = new ColumnResponseDto();
                    columnDto.setId(column.getId());
                    columnDto.setColumnName(column.getColumnName());
                    columnDto.setDataType(column.getDataType().getId());
                    columnListDtos.add(columnDto);
                }

                tableDto.setColumnList(columnListDtos);
                dtos.add(tableDto);
            }

            return dtos;
        } catch (Exception e) {
            throw e;
        }
    }

}
