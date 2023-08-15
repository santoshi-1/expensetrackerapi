package com.santoshi.expensetrackerapi.service;

import com.santoshi.expensetrackerapi.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.List;

public interface ExpenseService {

    Page<Expense> getAllExpenses(Pageable pageable);

    Expense getExpenseById(Long id);

    void deleteExpenseById(Long id);

    Expense saveExpenseDetails(Expense expense);

    Expense updateExpenseDetails(Long id, Expense expense);

    List<Expense> readByCategory(String category, Pageable pageable);

    List<Expense> searchExpenseByKeyword(String keyword, Pageable pageable);

    List<Expense> readByDate(Date startDate, Date endDate, Pageable pageable);

}
