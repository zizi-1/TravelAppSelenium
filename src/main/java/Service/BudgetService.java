package Service;

import org.springframework.stereotype.Service;

import persistence.domain.Budget;
import persistence.repo.BudgetRepo;
import persistence.repo.DetailsRepo;

@Service
public class BudgetService {
	
	private BudgetRepo budgetRepo;
	
	public BudgetService(BudgetRepo budgetRepo) {
		this.budgetRepo = budgetRepo;
	}

	
	private void setUpBudget() {
		Budget b = new Budget(8,8,8);
		budgetRepo.save(8);
	}
	
	public Budget updateBudget(Budget budget) {
		return budgetRepo.save(budget);
	}
}
