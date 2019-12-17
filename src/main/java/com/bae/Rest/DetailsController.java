package com.bae.Rest;

import com.bae.Service.DetailsService;
import com.bae.persistence.domain.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/details")
public class DetailsController {


    private DetailsService detailsService;

    @Autowired
    public DetailsController(DetailsService detailsService) {

        this.detailsService = detailsService;
    }

    @PostMapping("/add")
    public Details addNewDetails(@RequestBody Details details) {

        return detailsService.addNewDetails(details);
    }

    @PutMapping("/update")
    public Details updateDetails(@RequestBody Details details) {

        return detailsService.updateDetails(details);
    }



}
