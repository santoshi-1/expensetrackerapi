package com.santoshi.expensetrackerapi.service;

import com.santoshi.expensetrackerapi.entity.Expense;

import java.util.List;

public interface ExpenseService {

    List<Expense> getAllExpenses();
}
