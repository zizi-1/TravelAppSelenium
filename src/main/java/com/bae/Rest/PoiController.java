package com.bae.Rest;

import com.bae.Service.PoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bae.persistence.domain.Poi;

import java.util.List;

@RestController
@RequestMapping("/poi")
public class PoiController {


    private PoiService poiService;

    @Autowired
    public PoiController(PoiService poiService) {

        this.poiService = poiService;
    }

    @GetMapping("/All")
    public List<Poi> getAllPoi(@PathVariable Poi poi){

        return poiService.getAllPoi();
    }

    @PostMapping("/add")
    public Poi getPoi(@RequestBody Poi poi) {

        return poiService.addNewPoi(poi);
    }

    @PutMapping("/update")
    public Poi updatePoi(@RequestBody Poi poi) {

        return poiService.updatePoi(poi);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePoi(@PathVariable(value = "id") Long id) {

        return poiService.deletePoi(id);
    }


}
