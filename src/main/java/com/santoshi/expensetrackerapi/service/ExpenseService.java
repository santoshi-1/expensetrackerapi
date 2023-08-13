package com.santoshi.expensetrackerapi.service;

import com.santoshi.expensetrackerapi.entity.Expense;

import java.util.List;

public interface ExpenseService {

    List<Expense> getAllExpenses();

    Expense getExpenseById(Long id);

    void deleteExpenseById(Long id);

    Expense saveExpenseDetails(Expense expense);

    Expense updateExpenseDetails(Long id, Expense expense);

}
