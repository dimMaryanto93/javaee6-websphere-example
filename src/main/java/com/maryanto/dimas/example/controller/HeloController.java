package com.maryanto.dimas.example.controller;

import com.maryanto.dimas.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET, value = "/spring")
    public ModelAndView viewAll(ModelAndView view) {
        view.setViewName("/halo");
        view.addObject("message", "Halo from Controller");
        view.addObject("namaLengkap", employeeService.findById(202));
        return view;
    }

}
