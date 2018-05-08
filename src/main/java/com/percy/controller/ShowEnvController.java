package com.percy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/env")
@ResponseBody
public class ShowEnvController {
    @Autowired
    private Environment env;
    @RequestMapping(method = RequestMethod.GET)
    public String showEnv() {
        return env.toString();
    }
}
