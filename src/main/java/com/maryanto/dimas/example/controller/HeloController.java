package com.maryanto.dimas.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HeloController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @RequestMapping(method = RequestMethod.GET, value = "/spring")
    public ModelAndView viewAll(ModelAndView view) {
        view.setViewName("/halo");
        view.addObject("message", "Halo from Controller");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("employeeId", 100);
        String namaLengkap = jdbcTemplate.queryForObject(
                "select concat(concat(first_name, ' '), last_name) as nama_lengkap from employees where employee_id = :employeeId", params, new RowMapper<String>() {
                    @Override
                    public String mapRow(ResultSet resultSet, int i) throws SQLException {
                        return resultSet.getString("nama_lengkap");
                    }
                });
        view.addObject("namaLengkap", namaLengkap);
        return view;
    }

}
