package com.bae.persistence.repo;

import com.bae.persistence.domain.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepo extends JpaRepository <Details, Long> {


}
