package com.cba.Rule.Engine.model;
// Generated Jun 20, 2023 2:49:48 PM by Hibernate Tools 4.3.1


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


/**
 * PushDevice generated by hbm2java
 */
@Entity
@Table(name = "push_device"
)
public class PushDevice implements java.io.Serializable {

    private Long id;
    private Device device;
    private String pushId;
    private Set<PushdeviceOperation> pushdeviceOperations = new HashSet<PushdeviceOperation>(0);

    public PushDevice() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id", nullable = false)
    public Device getDevice() {
        return this.device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    @Column(name = "push_id", nullable = false, length = 100)
    public String getPushId() {
        return this.pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pushDevice")
    public Set<PushdeviceOperation> getPushdeviceOperations() {
        return this.pushdeviceOperations;
    }

    public void setPushdeviceOperations(Set<PushdeviceOperation> pushdeviceOperations) {
        this.pushdeviceOperations = pushdeviceOperations;
    }

}


