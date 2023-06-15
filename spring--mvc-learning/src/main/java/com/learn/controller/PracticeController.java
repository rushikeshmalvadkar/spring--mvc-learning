package com.learn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class PracticeController {

    @RequestMapping(value = "/practice/{firstname}" , method = RequestMethod.GET)
    public String pathVariablePractice(
            @PathVariable("firstname") String firstname, Model model){
        log.info("<<<<<<<<< pathVariablePractice()");
        model.addAttribute("userFirstName",firstname);
        log.info("pathVariablePractice() >>>>>>>>");
        return "path-param";
    }

    @RequestMapping(value = "/practice/{firstname}/{age}" , method = RequestMethod.GET)
    public String requestParamPractice(
            @PathVariable("firstname") String userFirstName,
            @PathVariable("age") Integer userAge, // automatic conversion from string to Integer
            @RequestParam("isMarried") Boolean isMarried,
            @RequestParam("lastname") String userLastName,
            Model model){
        log.info("<<<<<<<<< requestParamPractice()");
        model.addAttribute("userFirstName",userFirstName);
        model.addAttribute("userAge",userAge);
        model.addAttribute("userLastName",userLastName);
        model.addAttribute("isMarried",isMarried);
        log.info("requestParamPractice() >>>>>>>>>");
        return "request-param";
    }
}
