package com.santoshi.expensetrackerapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data // getter and setters
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "expense_name")
    private String name;

    private String description;

    @Column(name = "expense_amount")
    private BigDecimal amount;

    private String category;

    private Date date;

}
