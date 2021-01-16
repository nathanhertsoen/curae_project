package com.ulco.curae;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class CuraeApplication {
    @ApiModelProperty("Powered by Hertsoen Technology ©")
    public static void main(String[] args) {
        SpringApplication.run(CuraeApplication.class, args);

    }
}
