package com.bae.Rest;

import com.bae.Service.DetailsService;
import com.bae.persistence.domain.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    public List<Details> getAllPoi() {
        return this.detailsService.readPoi();
    }

    @PostMapping("/add")
    public Details addNewDetails(@RequestBody Details details) {

        return this.detailsService.addNewDetails(details);
    }

    @PutMapping("/update")
    public Details updateDetails(@PathParam("id") Long id, @RequestBody Details details) {

        return this.detailsService.updateDetails(id, details);
    }

    @DeleteMapping("/deletePond/{id}")
    public void deletePond(@PathVariable Long id) {
        this.detailsService.deleteDetails(id);
    }

}
