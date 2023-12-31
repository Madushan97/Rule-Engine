package com.cba.Rule.Engine.model;
// Generated Jun 20, 2023 2:49:48 PM by Hibernate Tools 4.3.1


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


/**
 * TransactionType generated by hbm2java
 */
@Entity
@Table(name = "transaction_type"
)
public class TransactionType implements java.io.Serializable {

    private String tranType;
    private Status status;
    private String description;
    private Set<TransactionSwitch> transactionSwitches = new HashSet<TransactionSwitch>(0);

    public TransactionType() {
    }

    @Id
    @Column(name = "tran_type", unique = true, nullable = false, length = 10)
    public String getTranType() {
        return this.tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status", nullable = false)
    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Column(name = "description", length = 100)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transactionType")
    public Set<TransactionSwitch> getTransactionSwitches() {
        return this.transactionSwitches;
    }

    public void setTransactionSwitches(Set<TransactionSwitch> transactionSwitches) {
        this.transactionSwitches = transactionSwitches;
    }

}


