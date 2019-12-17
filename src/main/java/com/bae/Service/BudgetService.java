package com.bae.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.persistence.domain.Budget;
import com.bae.persistence.repo.BudgetRepo;

@Service
public class BudgetService {
	
	private BudgetRepo budgetRepo;


	public BudgetService(BudgetRepo budgetRepo) {

		this.budgetRepo = budgetRepo;
	}

	public Budget addBudget(Budget budget){

		return (Budget) budgetRepo.findAll();
	}
	
	public Budget updateBudget(Budget budget) {

		return budgetRepo.save(budget);
	}

	public String deleteBudget(Long id) {
		budgetRepo.deleteById(id);
		return "Budget has been deleted";
	}
}
