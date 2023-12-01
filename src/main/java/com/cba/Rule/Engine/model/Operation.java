package com.cba.Rule.Engine.model;
// Generated Jun 20, 2023 2:49:48 PM by Hibernate Tools 4.3.1


import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Operation generated by hbm2java
 */
@Entity
@Table(name = "operation"
)
public class Operation implements java.io.Serializable {

    private long id;
    private String operationCode;
    private String description;
    private Date createdAt;
    private Date modifiedAt;
    private String status;
    private Set<PushdeviceOperation> pushdeviceOperations = new HashSet<PushdeviceOperation>(0);

    public Operation() {
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "operation_code", nullable = false, length = 10)
    public String getOperationCode() {
        return this.operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    @Column(name = "description", length = 100)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, length = 19)
    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at", length = 19)
    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Column(name = "status", nullable = false, length = 10)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "operation")
    public Set<PushdeviceOperation> getPushdeviceOperations() {
        return this.pushdeviceOperations;
    }

    public void setPushdeviceOperations(Set<PushdeviceOperation> pushdeviceOperations) {
        this.pushdeviceOperations = pushdeviceOperations;
    }

}


