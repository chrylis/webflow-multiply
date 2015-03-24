package com.chrylis.sandbox;

import java.util.Collections;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HtmlController extends BaseController {

    @Override
    public ModelAndView stuff(@PathVariable int value){
        Map<String, ? extends Object> model = Collections.singletonMap("stuff", doGetStuff(value));
        return new ModelAndView("stuff", model);
    }

    @PostConstruct
    public void log() {
        System.err.println("html");
    }
}
