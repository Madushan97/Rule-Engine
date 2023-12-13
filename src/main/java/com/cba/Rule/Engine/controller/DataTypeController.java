package com.cba.Rule.Engine.controller;

import com.cba.Rule.Engine.dto.DataTypesResponseDto;
import com.cba.Rule.Engine.dto.requestDto.DataTypeRequestDto;
import com.cba.Rule.Engine.model.DataType;
import com.cba.Rule.Engine.service.DataTypeService;
import com.cba.Rule.Engine.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/${application.resource.dataTypes}")
public class DataTypeController {

    private final DataTypeService dataTypeService;

    @GetMapping(path = "/getAll")
    public ResponseEntity<StandardResponse> getAll() {

        List<DataTypesResponseDto> getAllDataTypes = dataTypeService.getAllDataTypes();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        HttpStatus.OK.value(),
                        "get all Data Types successfully",
                        getAllDataTypes
                ),
                HttpStatus.OK
        );
    }

    @PostMapping(path = "/create")
    public ResponseEntity<StandardResponse> create(@RequestBody DataTypeRequestDto dataTypeRequestDto) {

        DataTypesResponseDto createDataType = dataTypeService.createDataType(dataTypeRequestDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        HttpStatus.CREATED.value(),
                        "create successfully",
                        createDataType
                ),
                HttpStatus.CREATED
        );
    }
}
