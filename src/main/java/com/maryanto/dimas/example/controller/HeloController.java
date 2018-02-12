package com.maryanto.dimas.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {

    @RequestMapping(method = RequestMethod.GET, value = "/spring")
    public ModelAndView viewAll(ModelAndView view) {
        view.setViewName("/halo");
        view.addObject("message", "Halo from Controller");
        return view;
    }

}
