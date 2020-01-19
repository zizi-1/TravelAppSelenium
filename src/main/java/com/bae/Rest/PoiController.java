package com.bae.Rest;

import com.bae.Service.PoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bae.persistence.domain.Poi;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/poi")
public class PoiController {


    private PoiService poiService;

    @Autowired
    public PoiController(PoiService poiService) {

        this.poiService = poiService;
    }

    @GetMapping("/all")
    public List<Poi> getAllPoi(){

        return poiService.getAllPoi();
    }

    @GetMapping("/get/{id}")
    public Poi getPoi(@PathVariable Long id) {

        return this.poiService.findPoiById(id);
    }

    @PostMapping("/add")
    public Poi addPoi(@RequestBody Poi poi) {

        return poiService.addNewPoi(poi);
    }

    @PutMapping("/update/{id}")
    public Poi updatePoi(@PathVariable("id") Long id, @RequestBody Poi poi) {


        return this.poiService.updatePoi(id, poi);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deletePoi(@PathVariable Long id) {

        return poiService.deletePoi(id);
    }


}
