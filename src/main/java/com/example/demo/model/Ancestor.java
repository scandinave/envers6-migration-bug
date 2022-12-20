package com.example.demo.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.util.Date;

@MappedSuperclass
public abstract class Ancestor {

    private Date lastUpdatedDate = null;

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    @PreUpdate
    @PrePersist
    protected void preUpdate() {
        lastUpdatedDate = new Date();
    }
}
