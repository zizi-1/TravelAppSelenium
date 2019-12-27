package com.bae.Service;

import com.bae.exceptions.DetailsNotFoundException;
import com.bae.persistence.domain.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.persistence.repo.DetailsRepo;

import java.util.List;

@Service
public class DetailsService {

	private DetailsRepo detailsRepo;
	private PoiService poiService;

	@Autowired
	public DetailsService(DetailsRepo detailsRepo, PoiService poiService) {
		this.poiService = poiService;
		this.detailsRepo = detailsRepo;
	}

	public Details addNewDetails(Details details) {

		return detailsRepo.save(details);
	}

	public boolean deleteDetails(Long id) {
		if (!this.detailsRepo.existsById(id)) {
			throw new DetailsNotFoundException();
		}
		this.detailsRepo.deleteById(id);
		return this.detailsRepo.existsById(id);
	}

	private Details findDetailsByID(Long id) {
		return this.detailsRepo.findById(id).orElseThrow(
				() -> new DetailsNotFoundException());
	}

	public List<Details> readPoi() {
		return this.detailsRepo.findAll();
	}

	public Details updateDetails(Long id, Details details) {
		Details Updated = findDetailsByID(id);
		Updated.setOrigin(details.getOrigin());
		Updated.setDestination(details.getDestination());
		Updated.setDateFrom(details.getDateFrom());
		Updated.setDateTo(details.getDateTo());
		Updated.setAllowance(details.getAllowance());
		Updated.setRemaining(details.getRemaining());
		Updated.setSpent(details.getSpent());
		return this.detailsRepo.save(Updated);


	}
}
