package com.cristik.business.entity.svo;

import javax.persistence.*;

@Table(name="signature")
public class Signature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer secretId;
    @Column
    private String secretKey;
    @Column
    private String userId;

    public Signature(Integer secretId, String secretKey, String userId) {
        this.secretId = secretId;
        this.secretKey = secretKey;
        this.userId = userId;
    }

    public Signature() {
        super();
    }

    public Integer getSecretId() {
        return secretId;
    }

    public void setSecretId(Integer secretId) {
        this.secretId = secretId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}