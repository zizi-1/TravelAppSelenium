package persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import persistence.domain.Budget;

public interface BudgetRepo extends JpaRepository<Budget, Long>{

}
