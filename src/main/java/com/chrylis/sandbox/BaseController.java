package com.chrylis.sandbox;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/path")
public abstract class BaseController {

    protected StuffDomain doGetStuff(int value) {
        return new StuffDomain(value * 2);
    }

    @RequestMapping("/stuff/{value}")
    public abstract Object stuff(@PathVariable int value);
}
