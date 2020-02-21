package com.demo.model;


import java.io.Serializable;
import java.util.List;

/**
 * @Description: 分页实体
 * @author: cuixiuyin
 * @date: 2020/2/20
 */
public class PageVO<T> implements Serializable {
    /**
     * 当前页数
     */
    private Integer pageNum;
    /**
     * 每页数据量
     */
    private Integer pageSize;
    /**
     * 数据总数
     */
    private Integer totalNum;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 是否有下一页
     */
    private Boolean isMore;
    /**
     * 分页数据
     */
    private List<T> items;

    public PageVO() {
    }

    public PageVO(Integer pageNum, Integer pageSize, Integer totalNum) {
        super();
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.totalPage = (this.totalNum + this.pageSize - 1) / this.pageSize;
        this.isMore = this.pageNum < this.totalPage;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Boolean getIsMore() {
        return isMore;
    }

    public void setIsMore(Boolean isMore) {
        this.isMore = isMore;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
