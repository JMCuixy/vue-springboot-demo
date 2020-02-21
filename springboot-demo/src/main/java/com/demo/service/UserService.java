package com.demo.service;

import com.demo.model.PageParam;
import com.demo.model.PageVO;
import com.demo.model.ResponseResult;
import com.demo.model.UserDO;

import java.util.List;
import java.util.Map;

/**
 * @author : cuixiuyin
 * @date : 2020/2/20
 */
public interface UserService {

    ResponseResult<Boolean> add(UserDO instance);

    ResponseResult<Boolean> edit(UserDO instance);

    ResponseResult<Boolean> del(Long id);

    ResponseResult<UserDO> get(Map<String, Object> params);

    ResponseResult<UserDO> get(Long id);

    ResponseResult<List<UserDO>> list(Map<String, Object> params);

    /**
     * 后台分页查询
     */
    <Param extends PageParam> ResponseResult<PageVO<UserDO>> queryPage(Param pageParam);
}
