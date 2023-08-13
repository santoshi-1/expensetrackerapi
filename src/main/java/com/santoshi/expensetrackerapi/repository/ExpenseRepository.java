package com.santoshi.expensetrackerapi.repository;

import com.santoshi.expensetrackerapi.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
