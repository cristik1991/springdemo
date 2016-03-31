package com.cristik.business.entity.svo;

import javax.persistence.*;
import java.util.Date;

@Table(name="operation_log")
public class OperationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String userid;
    @Column
    private Date createdate;
    @Column
    private String content;
    @Column
    private String operation;

    public OperationLog(Integer id, String userid, Date createdate, String content, String operation) {
        this.id = id;
        this.userid = userid;
        this.createdate = createdate;
        this.content = content;
        this.operation = operation;
    }

    public OperationLog() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
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

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", createdate=" + createdate +
                ", content='" + content + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }
}