package com.digitalinnovationone.course11springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @Value("${app.message}")
    private String appMessage;

    @Value("${ENV_DB_URL:NO_ONE}")
    private String dbEnvironment;

    @GetMapping("/")
    public String getAppMessage() {
        return appMessage;
    }

    @GetMapping("/env")
    public String getDbEnvironment() {
        return String.format("The following ENV variable has passed: %s", dbEnvironment);
    }
}
