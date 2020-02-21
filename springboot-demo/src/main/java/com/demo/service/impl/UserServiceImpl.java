package com.demo.service.impl;

import com.demo.dao.UserDao;
import com.demo.model.PageParam;
import com.demo.model.PageVO;
import com.demo.model.ResponseResult;
import com.demo.model.UserDO;
import com.demo.service.UserService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : cuixiuyin
 * @date : 2020/2/20
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ResponseResult<Boolean> add(UserDO userDO) {
        userDO.setCreateOn(new Date());
        if (userDao.add(userDO) > 0) {
            return ResponseResult.buildSuccessResponse(Boolean.TRUE);
        }
        return ResponseResult.buildErrorResponse(ResponseResult.ERROR_CODE, "新增失败");
    }

    @Override
    public ResponseResult<Boolean> edit(UserDO userDO) {
        userDO.setUpdateOn(new Date());
        if (userDao.edit(userDO) > 0) {
            return ResponseResult.buildSuccessResponse(Boolean.TRUE);
        }
        return ResponseResult.buildErrorResponse(ResponseResult.ERROR_CODE, "修改失败");
    }

    @Override
    public ResponseResult<Boolean> del(Long id) {
        if (userDao.del(id) > 0) {
            return ResponseResult.buildSuccessResponse(Boolean.TRUE);
        }
        return ResponseResult.buildErrorResponse(ResponseResult.ERROR_CODE, "删除失败");
    }


    @Override
    public ResponseResult<UserDO> get(Map<String, Object> paramMap) {
        List<UserDO> list = userDao.list(paramMap);
        if (list.size() > 0) {
            return ResponseResult.buildSuccessResponse(list.get(0));
        }
        return ResponseResult.buildErrorResponse(ResponseResult.ERROR_CODE, "查询失败");
    }

    @Override
    public ResponseResult<UserDO> get(Long id) {
        HashMap<String, Object> paramMap = new HashMap<>(2);
        paramMap.put("id", id);
        return get(paramMap);
    }

    @Override
    public ResponseResult<List<UserDO>> list(Map<String, Object> paramMap) {
        return ResponseResult.buildSuccessResponse(userDao.list(paramMap));
    }

    @Override
    public <Param extends PageParam> ResponseResult<PageVO<UserDO>> queryPage(Param pageParam) {
        PageBounds pageBounds = new PageBounds(pageParam.getPageNum(), pageParam.getPageSize());
        PageList<UserDO> pageList = userDao.queryPage(BeanMap.create(pageParam), pageBounds);
        PageVO<UserDO> pageVo = new PageVO(pageParam.getPageNum(), pageParam.getPageSize(), pageList.getPaginator().getTotalCount());
        pageVo.setItems(pageList);
        return ResponseResult.buildSuccessResponse(pageVo);
    }
}
