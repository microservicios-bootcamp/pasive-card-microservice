package com.demo.app.product.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.Date;

@Document(collection = "card")
@Data
public class Card {

    @Id
    private String id;

    @Field(name = "account_type")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private TypeCurrency currency;

    @Field(name = "account_number")
    private String accountNumber;

    private Integer cvc;

    @CreatedDate
    @Field(name = "create_at")
    private Date createAt;

    @LastModifiedDate
    @Field(name = "update_at")
    private Date updateAt;

}
