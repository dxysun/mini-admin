package com.netease.miniadmin.model;

/**
 * @author XiaBin
 * @date 2019-07-31 14:28
 * 分页实体类
 */
public class PageQuery {

    /**
     * 当前索引位置
     */
    private Integer currentIndex;

    /**
     * 每页大小
     */
    private Integer pageSize;

    public Integer getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(Integer currentIndex) {
        this.currentIndex = currentIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

