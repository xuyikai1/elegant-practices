package com.example.paydemo.jd.vo;

import java.io.Serializable;
import java.util.Date;

public class EquitiesInfo implements Serializable{

    private static final long serialVersionUID = -3262414245464717821L;
    /**
     * 权益id
     */
    private Long id;
    /**
     * 权益标题
     */
    private String title;
    /**
     * 权益内容说明
     */
    private String content;
    /**
     * 权益当前状态
     * (0:未启用,1:启用,2:过期,3:禁用)
     */
    private Integer status;
    /**
     * 有效时间
     */
    private Date validityDate;
    /**
     * 样式主题
     */
    private String theme;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
