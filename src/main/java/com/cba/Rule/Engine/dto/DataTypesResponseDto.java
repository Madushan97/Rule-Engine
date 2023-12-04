package com.cba.Rule.Engine.dto;

import com.cba.Rule.Engine.model.CardLabel;
import com.cba.Rule.Engine.model.PaymentMethods;
import jakarta.persistence.EnumType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DataTypesResponseDto {

    private Integer id;
    private EnumType type;
    private List<CardLabel> cardLabel;
    private List<PaymentMethods> paymentMethods;
}
