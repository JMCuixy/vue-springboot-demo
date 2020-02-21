package com.demo.controller;

import com.demo.model.PageParam;
import com.demo.model.PageVO;
import com.demo.model.ResponseResult;
import com.demo.model.UserDO;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * @author : cuixiuyin
 * @date : 2020/2/20
 */
@RestController
@RequestMapping("/admin/v1")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(value = "/login")
    public ResponseResult<UserDO> loadList(@RequestBody UserDO userDO) {
        UserDO loginUser = new UserDO();
        loginUser.setId(1L);
        loginUser.setUserName("张三");
        loginUser.setSex("Male");
        loginUser.setAddress("福建省厦门市");
        loginUser.setCreateOn(new Date());
        return ResponseResult.buildSuccessResponse(loginUser);
    }

    @PostMapping(value = "/queryPage")
    public ResponseResult<PageVO<UserDO>> loadList(@RequestBody PageParam pageParam) {
        return userService.queryPage(pageParam);
    }

    @PostMapping(value = "/addUser")
    public ResponseResult<Boolean> addUser(@RequestBody UserDO userDO) {
        return userService.add(userDO);
    }

    @GetMapping(value = "/userDetail")
    public ResponseResult<UserDO> userDetail(@RequestParam("id") Long id) {
        return userService.get(id);
    }

    @PostMapping(value = "/editUser")
    public ResponseResult<Boolean> editUser(@RequestBody UserDO userDO) {
        return userService.edit(userDO);
    }

    @RequestMapping(value = "/delUser/{id}", method = RequestMethod.POST)
    public ResponseResult<Boolean> delUser(@PathVariable("id") Long id) {
        return userService.del(id);
    }
}
