package com.santoshi.expensetrackerapi.repository;

import com.santoshi.expensetrackerapi.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    //Select * from tbl_expenses where userId=? and category=category_name
    Page<Expense> findByUserIdAndCategory(Long userId, String category, Pageable pageable);

    //select * from tbl_expenses where userId=? and name LIKE '%keyword%'
    Page<Expense> findByUserIdAndNameContaining(Long userId, String keyword, Pageable pageable);

    //Select * form tbl_expenses where userId=? and date BETWEEN 'startDate' and 'endDate'
    Page<Expense> findByUserIdAndDateBetween(Long userId, Date startDate, Date endDate, Pageable pageable);

    //Select * form tbl_expenses where user_id=?
    Page<Expense> findByUserId(Long user, Pageable pageable);

    //Select * form tbl_expenses where user_id=? and id=?
    Optional<Expense> findByUserIdAndId(Long userId, Long expenseId);
}
