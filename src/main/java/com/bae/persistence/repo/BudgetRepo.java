package com.bae.persistence.repo;

import com.bae.persistence.domain.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepo extends JpaRepository <Budget, Long>{

}
