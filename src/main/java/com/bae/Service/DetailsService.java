package com.bae.Service;

import com.bae.persistence.domain.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.persistence.repo.DetailsRepo;

@Service
public class DetailsService {

	private DetailsRepo detailsRepo;

	@Autowired
	public DetailsService(DetailsRepo detailsRepo) {

		this.detailsRepo = detailsRepo;
	}

	public Details addNewDetails(Details details) {

		return detailsRepo.save(details);
	}

	public Details updateDetails(Details details) {

		return detailsRepo.save(details);
	}
}
