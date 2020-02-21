package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : cuixiuyin
 * @date : 2020/2/20
 */
@Controller
public class BaseController {

    @RequestMapping("/")
    public String forward() {
        return "redirect:admin/index/";
    }
}
