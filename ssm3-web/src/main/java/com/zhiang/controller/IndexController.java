package com.zhiang.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by mengzhiang on 2017/7/6.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request) throws IOException, ServletException {
        Map<String, Object> map = new HashMap<String, Object>();

        return new ModelAndView("index",map);
    }
}
