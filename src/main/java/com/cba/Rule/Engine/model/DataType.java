package com.cba.Rule.Engine.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "data_type")
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class DataType {

    private Integer id;
    private String type;
    private List<CardLabel> cardLabel;
    private List<PaymentMethods> paymentMethods;
    private List<ColumnList> columnList;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    @JsonManagedReference(value = "cardLabel")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "dataType", cascade = CascadeType.ALL)
    public List<CardLabel> getCardLabel() {
        return cardLabel;
    }

    public void setCardLabel(List<CardLabel> cardLabel) {
        this.cardLabel = cardLabel;
    }

//    @JsonManagedReference(value = "paymentMethod")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "dataType", cascade = CascadeType.ALL)
    public List<PaymentMethods> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethods> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

//    @JsonManagedReference(value = "columnList")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "dataType", cascade = CascadeType.ALL)
    public List<ColumnList> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<ColumnList> columnList) {
        this.columnList = columnList;
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
