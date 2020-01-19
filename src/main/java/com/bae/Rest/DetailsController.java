package com.bae.Rest;

import com.bae.Service.DetailsService;
import com.bae.exceptions.DetailsNotFoundException;
import com.bae.exceptions.PoiNotFoundException;
import com.bae.persistence.domain.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details")
public class DetailsController {


    private DetailsService detailsService;

    @Autowired
    public DetailsController(DetailsService detailsService) {

        this.detailsService = detailsService;
    }

    @GetMapping("/getAll")
    public List<Details> getAllDetails() {
        return this.detailsService.readDetails();
    }

    @GetMapping("/get/{id}")
    public Details getDetails(@PathVariable Long id) throws DetailsNotFoundException {

        return this.detailsService.findDetailsByID(id);
    }

    @PostMapping("/add")
    public Details addNewDetails(@RequestBody Details details) {

        return this.detailsService.addNewDetails(details);
    }

    @PutMapping("/update/{id}")
    public Details updateDetails(@PathVariable("id") Long id, @RequestBody Details details) throws DetailsNotFoundException {

        return this.detailsService.updateDetails(id, details);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDetails(@PathVariable Long id) throws DetailsNotFoundException {

        this.detailsService.deleteDetails(id);
    }

}
