package com.santoshi.expensetrackerapi.repository;

import com.santoshi.expensetrackerapi.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    //Select * from tbl_expenses where category=category_name
    Page<Expense> findByCategory(String category, Pageable pageable);

    //select * from tbl_expenses where name LIKE '%keyword%'
    Page<Expense> findByNameContaining(String keyword, Pageable pageable);

    //Select * form tbl_expenses where date BETWEEN 'startDate' and 'endDate'
    Page<Expense> findByDateBetween(Date startDate, Date endDate, Pageable pageable);

}
