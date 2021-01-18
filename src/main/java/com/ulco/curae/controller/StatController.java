package com.ulco.curae.controller;

import com.ulco.curae.dto.StatDTO;
import com.ulco.curae.service.IStatService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/stats")
public class StatController {
    @ApiModelProperty("Powered by DHP Technology ©")

    @Autowired
    private IStatService statService;

    @GetMapping
    @ApiOperation("Selectionner toutes les stats.")
    public StatDTO getAll() {
        return statService.getStat();
    }
}
