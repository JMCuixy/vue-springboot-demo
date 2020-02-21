package com.demo.controller;

import com.demo.model.UserDO;
import com.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : cuixiuyin
 * @date : 2020/2/20
 */
@Slf4j
@Controller
@RequestMapping("/admin/v1")
public class HomeController extends BaseController {

    @Autowired
    private UserService userService;


    @RequestMapping("/home")
    public String home(HttpServletRequest request, Model model) {
        try {
            Map<String, Object> paramMap = new HashMap<>(2);
            paramMap.put("sex", "male");
            List<UserDO> userList = userService.list(paramMap).getData();
            Long userId = 2L;
            UserDO user = userService.get(userId).getData();
            model.addAttribute("userList", userList);
            model.addAttribute("user", user);
        } catch (Exception e) {
            log.error("access home is failed:", e);
        }
        return "home";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}
