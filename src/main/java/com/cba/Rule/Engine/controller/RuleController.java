package com.cba.Rule.Engine.controller;

import com.cba.Rule.Engine.dto.RuleResponseDto;
import com.cba.Rule.Engine.model.Rule;
import com.cba.Rule.Engine.service.RuleService;
import com.cba.Rule.Engine.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/${application.resource.rules}")
public class RuleController {

    private final RuleService ruleService;

    @PostMapping(path = "/create")
    public ResponseEntity<StandardResponse> create(@RequestBody Rule rule) {

        RuleResponseDto createRule = ruleService.createRule(rule);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        HttpStatus.CREATED.value(),
                        "create successfully",
                        createRule
                ),
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<StandardResponse> getAll() {

        List<RuleResponseDto> getAllRules = ruleService.getAllRules();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        HttpStatus.OK.value(),
                        "get all rules successfully",
                        getAllRules
                ),
                HttpStatus.OK
        );
    }
}
