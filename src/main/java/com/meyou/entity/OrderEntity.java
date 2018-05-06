package com.meyou.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lipeng on 2018/05/06.
 */
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = -1;

    private String orderId;

    private Long totalAmount;

    private Long mytAmount;

    private String status;

    private String currency;

    private Date addTime;

    private Date updateTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getMytAmount() {
        return mytAmount;
    }

    public void setMytAmount(Long mytAmount) {
        this.mytAmount = mytAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
