package com.bae.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bae.persistence.repo.PoiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.persistence.domain.Poi;

@Service
public class PoiService {

	private PoiRepo poiRepo;

	@Autowired
	public PoiService(PoiRepo poiRepo) {

		this.poiRepo = poiRepo;
	}

	public List<Poi> getAllPoi(){
		if (poiRepo.findAll().isEmpty()){
			setUpPoi();
		}
		return poiRepo.findAll();
	}

	private void setUpPoi() {
		Poi z = new Poi("zohaib","url");
		Poi x = new Poi("dubai","url2");
		poiRepo.save(z);
		poiRepo.save(x);
	}

	 public Poi getPoi(String name) {

		return null;
	 }

	public Poi addNewPoi(Poi p) {

		return poiRepo.save(p);
	}

	public Poi updatePoi(Poi p) {

		return poiRepo.save(p);
	}

	public String deletePoi(Long id) {
		poiRepo.deleteById(id);
		return "Poi deleted successfully";
	}
}
