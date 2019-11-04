package com.example.demo.email.controller;

import com.example.demo.email.util.OkResponse;
import com.example.demo.email.util.Example;
import com.example.demo.email.form.EmailForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/v1/email")
public class Controller {
    private Example example;

    @Autowired
    public Controller(Example example) {
        this.example = example;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public OkResponse sendEmail(@RequestBody EmailForm form) throws IOException {
        example.sendEmail(form);
        return new OkResponse();
    }
}
