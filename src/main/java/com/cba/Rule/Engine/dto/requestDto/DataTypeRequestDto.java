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
@Data
public class DataTypeRequestDto {

    private Integer id;
    private String type;
    private List<CardLabel> cardLabel;
    private List<PaymentMethods> paymentMethods;
    private List<ColumnList> columnList;
}
