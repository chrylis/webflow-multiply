package com.chrylis.sandbox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;

@RequestMapping(value = "/path", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class JsonController extends BaseController {

    @Override
    public StuffDto stuff(@PathVariable int value) {
        return new StuffDto(doGetStuff(value).getValue(), "hello");
    }

    @Autowired
    FlowDefinitionRegistry flows;

    @RequestMapping("/flows")
    public String okay() {
        return "hi";
    }
}
