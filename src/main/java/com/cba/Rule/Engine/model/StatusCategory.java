package com.cba.Rule.Engine.model;
// Generated Jun 20, 2023 2:49:48 PM by Hibernate Tools 4.3.1


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 * StatusCategory generated by hbm2java
 */
@Entity
@Table(name = "status_category"
)
public class StatusCategory implements java.io.Serializable {

    private String categoryCode;
    private String description;

    public StatusCategory() {
    }

    @Id
    @Column(name = "category_code", unique = true, nullable = false, length = 10)
    public String getCategoryCode() {
        return this.categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    @Column(name = "description", length = 100)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}


