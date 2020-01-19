package com.bae.Service;

import com.bae.exceptions.PoiNotFoundException;
import com.bae.persistence.domain.Poi;
import com.bae.persistence.repo.PoiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoiService {

    private PoiRepo poiRepo;

    @Autowired
    public PoiService(PoiRepo poiRepo) {

        this.poiRepo = poiRepo;
    }

    public List<Poi> getAllPoi() {
        return this.poiRepo.findAll();
    }

    public Poi findPoiById(Long id) {

        return this.poiRepo.findById(id).orElseThrow(PoiNotFoundException::new);
    }

    public Poi addNewPoi(Poi p) {

        return this.poiRepo.save(p);
    }

    public Poi updatePoi(Long id, Poi poi) {
        Poi toUpdate = findPoiById(id);
        toUpdate.setPoiName(poi.getPoiName());
        toUpdate.setLink(poi.getLink());
        return this.poiRepo.save(toUpdate);
    }

    public boolean deletePoi(Long id) throws PoiNotFoundException {
        if (this.poiRepo.existsById(id)) {
            this.poiRepo.deleteById(id);
        } else {
            throw new PoiNotFoundException();
        }

        return this.poiRepo.existsById(id);
    }

}
