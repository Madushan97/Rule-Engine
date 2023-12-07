package com.cba.Rule.Engine.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rule_configuration")
@AllArgsConstructor
@NoArgsConstructor
public class RuleConfiguration {

    private Integer id;
    private TableStructure tableId;
    private ColumnList columnId;
    private String action;
    private String value;
    private Rule rule;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    @JsonBackReference
//  TODO  should use LAZY
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "table_id")
    public TableStructure getTableId() {
        return tableId;
    }

    public void setTableId(TableStructure tableId) {
        this.tableId = tableId;
    }

//    @JsonBackReference
//  TODO  should use LAZY
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "column_id")
    public ColumnList getColumnId() {
        return columnId;
    }

    public void setColumnId(ColumnList columnId) {
        this.columnId = columnId;
    }

    @Column(name = "action", nullable = false, length = 20)
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Column(name = "value", nullable = false, length = 50)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rule_id")
    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }
}
