package com.cba.Rule.Engine.dto.requestDto;

import com.cba.Rule.Engine.model.CardLabel;
import com.cba.Rule.Engine.model.ColumnList;
import com.cba.Rule.Engine.model.PaymentMethods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class DataTypeRequestDto {

    private Integer id;
    private String type;
    private List<CardLabelRequestDto> cardLabel;
    private List<PaymentMethodsRequestDto> paymentMethods;
    private List<ColumnListRequestDto> columnList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<CardLabelRequestDto> getCardLabel() {
        return cardLabel;
    }

    public void setCardLabel(List<CardLabelRequestDto> cardLabel) {
        this.cardLabel = cardLabel;
    }

    public List<PaymentMethodsRequestDto> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethodsRequestDto> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public List<ColumnListRequestDto> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<ColumnListRequestDto> columnList) {
        this.columnList = columnList;
    }
}
