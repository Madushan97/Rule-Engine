package com.cba.Rule.Engine.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "table_list")
@AllArgsConstructor
@NoArgsConstructor
public class TableStructure {

    private Integer id;
    private String tableName;
    private Set<ColumnList> columnList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "table_name", nullable = false, length = 25)
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tableStructure", cascade = CascadeType.ALL)
    public Set<ColumnList> getColumnList() {
        return columnList;
    }

    public void setColumnList(Set<ColumnList> columnList) {
        this.columnList = columnList;
    }
}
