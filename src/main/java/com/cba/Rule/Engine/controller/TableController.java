package com.cba.Rule.Engine.controller;

import com.cba.Rule.Engine.dto.DataTypesResponseDto;
import com.cba.Rule.Engine.dto.TableResponseDto;
import com.cba.Rule.Engine.service.TableService;
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
@RequestMapping("/${application.resource.tables}")
public class TableController {

    private final TableService tableService;

    @GetMapping(path = "/getAll")
    public ResponseEntity<StandardResponse> getAll() {

        List<TableResponseDto> getAllTables = tableService.getAllTables();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        "get all Tables successfully",
                        getAllTables
                ),
                HttpStatus.OK
        );
    }
}
