package com.cba.Rule.Engine.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "data_type")
@AllArgsConstructor
@NoArgsConstructor
public class DataType implements java.io.Serializable{

    private Integer id;
    private String type;
    private Set<CardLabel> cardLabel;
    private Set<PaymentMethods> paymentMethods;
    private Date createdAt;
    private Date updatedAt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "dataType", cascade = CascadeType.ALL)
    public Set<CardLabel> getCardLabel() {
        return cardLabel;
    }

    public void setCardLabel(Set<CardLabel> cardLabel) {
        this.cardLabel = cardLabel;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "dataType", cascade = CascadeType.ALL)
    public Set<PaymentMethods> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(Set<PaymentMethods> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, length = 19)
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false, length = 19)
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
