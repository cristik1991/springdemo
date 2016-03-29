package com.cristik.business.entity.svo;

import java.util.Date;

public class Log {
    private Long id;

    private Long userid;

    private Date createdate;

    private String content;

    private String operation;

    public Log(Long id, Long userid, Date createdate, String content, String operation) {
        this.id = id;
        this.userid = userid;
        this.createdate = createdate;
        this.content = content;
        this.operation = operation;
    }

    public Log() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}