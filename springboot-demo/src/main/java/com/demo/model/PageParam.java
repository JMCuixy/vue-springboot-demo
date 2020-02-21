package com.demo.model;

import java.io.Serializable;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/06/14 15:17
 */
public class PageParam implements Serializable {

    private final Integer MIN_PAGE = 1;
    private final Integer MAX_PAGE = 10000;
    private final Integer DEFAULT_PAGE_SIZE = 10;

    /**
     * 当前页数
     */
    private Integer pageNum = MIN_PAGE;

    /**
     * 每页数据量
     */
    private Integer pageSize = DEFAULT_PAGE_SIZE;

    /**
     * 排序字段，格式类似于‘age.asc,gender.desc’
     */
    private String sortString;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum < MIN_PAGE ? MIN_PAGE : pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize > MAX_PAGE ? MAX_PAGE : pageSize;
    }

    public String getSortString() {
        return sortString;
    }

    public void setSortString(String sortString) {
        this.sortString = sortString;
    }
}
