package com.meyou.common;

import com.lvbby.garfield.api.enums.ArticleOrderByEnum;

import java.util.Date;

/**
 *
 * @author dushang.lp
 * @version $Id: BasePageRequest.java, v 0.1 2018年03月01日 下午4:38 dushang.lp Exp $
 */
public class BasePageRequest extends BaseRequest {
    private static final long serialVersionUID = 7711086053011027088L;
    private int pageNo = 1;
    private int pageSize = 10;
    /* 不为空表示根据offset查询 */
    private Integer offset;
    private Date createTimeStart;
    private Date createTimeEnd;
    private Date updateTimeStart;
    private Date updateTimeEnd;
    private boolean desc = true;

    public <T extends BasePageRequest>  T page(int pageNo , int pageSize){
        setPageNo(pageNo);
        setPageSize(pageSize);
        return (T) this;
    }
    /**
     * 排序
     * @see com.lvbby.garfield.api.enums.ArticleOrderByEnum
     */
    private String order = ArticleOrderByEnum.updateTime.name();

    public boolean isDesc() {
        return desc;
    }

    public void setDesc(boolean desc) {
        this.desc = desc;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * Getter method for property   pageNo.
     *
     * @return property value of pageNo
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * Setter method for property   pageNo .
     *
     * @param pageNo  value to be assigned to property pageNo
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * Getter method for property   pageSize.
     *
     * @return property value of pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * Setter method for property   pageSize .
     *
     * @param pageSize  value to be assigned to property pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Date getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public Date getUpdateTimeStart() {
        return updateTimeStart;
    }

    public void setUpdateTimeStart(Date updateTimeStart) {
        this.updateTimeStart = updateTimeStart;
    }

    public Date getUpdateTimeEnd() {
        return updateTimeEnd;
    }

    public void setUpdateTimeEnd(Date updateTimeEnd) {
        this.updateTimeEnd = updateTimeEnd;
    }
}