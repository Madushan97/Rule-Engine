package com.cba.Rule.Engine.model;
// Generated Jun 20, 2023 2:49:48 PM by Hibernate Tools 4.3.1


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


/**
 * Bank generated by hbm2java
 */
@Entity
@Table(name = "bank"
)
public class Bank implements java.io.Serializable {

    private String bankCode;
    private Status status;
    private String bankName;
    private String bankUrll;
    private String bankNii;
    private Set<Merchant> merchants = new HashSet<Merchant>(0);
    private Set<TransactionSwitch> transactionSwitches = new HashSet<TransactionSwitch>(0);

    public Bank() {
    }

    @Id
    @Column(name = "bank_code", unique = true, nullable = false, length = 16)
    public String getBankCode() {
        return this.bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status", nullable = false)
    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Column(name = "bank_name", nullable = false, length = 100)
    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Column(name = "bank_urll", length = 100)
    public String getBankUrll() {
        return this.bankUrll;
    }

    public void setBankUrll(String bankUrll) {
        this.bankUrll = bankUrll;
    }

    @Column(name = "bank_nii", length = 100)
    public String getBankNii() {
        return this.bankNii;
    }

    public void setBankNii(String bankNii) {
        this.bankNii = bankNii;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bank")
    public Set<Merchant> getMerchants() {
        return this.merchants;
    }

    public void setMerchants(Set<Merchant> merchants) {
        this.merchants = merchants;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bank")
    public Set<TransactionSwitch> getTransactionSwitches() {
        return this.transactionSwitches;
    }

    public void setTransactionSwitches(Set<TransactionSwitch> transactionSwitches) {
        this.transactionSwitches = transactionSwitches;
    }

}


