package com.demo.dao;

import com.demo.model.UserDO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author : cuixiuyin
 * @date : 2020/2/20
 */
@Repository
public interface UserDao {

    /**
     * 新增
     *
     * @param userDO 对象
     * @return int
     */
    Integer add(UserDO userDO);

    /**
     * 编辑
     *
     * @param userDO 对象
     * @return int
     */
    Integer edit(UserDO userDO);

    /**
     * 删除
     *
     * @param id 对象id
     * @return int
     */
    Integer del(Long id);

    /**
     * list列表
     *
     * @param paramMap Map查询条件
     * @return List<对象>
     */
    List<UserDO> list(Map<String, Object> paramMap);

    /**
     * 分页查询
     *
     * @param paramMap   Map查询条件
     * @param pageBounds 分页对象
     * @return PageList<对象>
     */
    PageList<UserDO> queryPage(Map<String, Object> paramMap, PageBounds pageBounds);
}
