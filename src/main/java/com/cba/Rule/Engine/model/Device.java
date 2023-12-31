package com.cba.Rule.Engine.model;
// Generated Jun 20, 2023 2:49:48 PM by Hibernate Tools 4.3.1


import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Device generated by hbm2java
 */
@Entity
@Table(name = "device"
)
@EntityListeners(AuditingEntityListener.class) // enable entity level auditing for create,modified attributes
public class Device implements java.io.Serializable {

    private Integer id;
    private Status status;
    @CreatedBy
    private String userByCreatedBy;
    @LastModifiedBy
    private String userByModifiedBy;
    private String serialNo;
    private String emiNo;
    private String deviceType;
    private String uniqueId;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    private Set<PushDevice> pushDevices = new HashSet<PushDevice>(0);
    private Set<DeviceConfig> deviceConfigs = new HashSet<DeviceConfig>(0);
    private Set<User> users = new HashSet<User>(0);

    public Device() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status", nullable = false)
    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Column(name = "created_by", nullable = false, length = 45)
    public String getUserByCreatedBy() {
        return this.userByCreatedBy;
    }

    public void setUserByCreatedBy(String userByCreatedBy) {
        this.userByCreatedBy = userByCreatedBy;
    }

    @Column(name = "modified_by", length = 45)
    public String getUserByModifiedBy() {
        return this.userByModifiedBy;
    }

    public void setUserByModifiedBy(String userByModifiedBy) {
        this.userByModifiedBy = userByModifiedBy;
    }

    @Column(name = "serial_no", nullable = false, length = 150)
    public String getSerialNo() {
        return this.serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    @Column(name = "emi_no", nullable = false, length = 50)
    public String getEmiNo() {
        return this.emiNo;
    }

    public void setEmiNo(String emiNo) {
        this.emiNo = emiNo;
    }

    @Column(name = "device_type", nullable = false, length = 20)
    public String getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @Column(name = "unique_id")
    public String getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
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
    @Column(name = "updated_at", length = 19)
    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "device")
    public Set<PushDevice> getPushDevices() {
        return this.pushDevices;
    }

    public void setPushDevices(Set<PushDevice> pushDevices) {
        this.pushDevices = pushDevices;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "device")
    public Set<DeviceConfig> getDeviceConfigs() {
        return this.deviceConfigs;
    }

    public void setDeviceConfigs(Set<DeviceConfig> deviceConfigs) {
        this.deviceConfigs = deviceConfigs;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "device")
    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}


