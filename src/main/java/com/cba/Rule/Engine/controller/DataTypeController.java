package com.cba.Rule.Engine.controller;

import com.cba.Rule.Engine.dto.DataTypesResponseDto;
import com.cba.Rule.Engine.service.DataTypeService;
import com.cba.Rule.Engine.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                        200,
                        "get all Data Types successfully",
                        getAllDataTypes
                ),
                HttpStatus.OK
        );
    }
}
