package com.bae.Rest;

import com.bae.Service.BudgetService;
import com.bae.persistence.domain.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/budget")
public class BudgetController {


    private BudgetService budgetService;

    @Autowired
    public BudgetController(BudgetService budgetService) {

        this.budgetService = budgetService;
    }

    @GetMapping("/total")
    public Budget addBudget(@RequestBody Budget budget){

        return budgetService.addBudget(budget);
    }

    @PutMapping("/remaining")
    public Budget updateAllowance(@RequestBody Budget budget){

        return budgetService.updateBudget(budget);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBudget(@PathVariable (value = "id") Long id){

        return budgetService.deleteBudget(id);
    }

}
