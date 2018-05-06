package com.meyou.common;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author dushang.lp
 * @version $Id: BasePageResult.java, v 0.1 2017-09-18 dushang.lp Exp $
 */
public class BasePageResponse<T> extends BaseResponse<List<T>> {
    private int totalCount = 0;
    private int pageCount = 0;
    private int page = 0;
    private int pageSize = 0;
    private boolean hasNext = true;
    private List<T> data;

    public BasePageResponse() {
    }

    public static <T> BasePageResponse suc(List<T> data, int page, int pageSize, int totalCount) {
        return new BasePageResponse<>(data, page, pageSize, totalCount);
    }

    public static <T> BaseResponse<T> err(String errorMsg) {
        return error(null,errorMsg).copy(BasePageResponse.class);
    }

    public static <T> BaseResponse<T> err(String errorCode,String errorMsg) {
        return error(errorCode,errorMsg).copy(BasePageResponse.class);
    }

    private BasePageResponse(List<T> data, int page, int pageSize, int totalCount) {
        this.totalCount = totalCount;
        this.page = page;
        this.data = data;
        this.pageSize = pageSize;
        this.pageCount = totalCount / pageSize + (totalCount % pageSize == 0 ? 0 : 1);
        this.hasNext = pageCount != page;
    }

    public <A> BasePageResponse<A> convert(Function<T, A> function) {
        List<A> re = null;
        if (CollectionUtils.isNotEmpty(data)) {
            re = data.stream().map(function).collect(Collectors.toList());
        }
        return new BasePageResponse(re, page, pageSize, totalCount);
    }

    /**
     * Getter method for property   totalCount.
     *
     * @return property value of totalCount
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * Setter method for property   totalCount .
     *
     * @param totalCount value to be assigned to property totalCount
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * Getter method for property   pageCount.
     *
     * @return property value of pageCount
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * Setter method for property   pageCount .
     *
     * @param pageCount value to be assigned to property pageCount
     */
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * Getter method for property   page.
     *
     * @return property value of page
     */
    public int getPage() {
        return page;
    }

    /**
     * Setter method for property   page .
     *
     * @param page value to be assigned to property page
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * Getter method for property   data.
     *
     * @return property value of data
     */
    public List<T> getData() {
        return data;
    }

    /**
     * Setter method for property   data .
     *
     * @param data value to be assigned to property data
     */
    public void setData(List<T> data) {
        this.data = data;
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
     * @param pageSize value to be assigned to property pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

}