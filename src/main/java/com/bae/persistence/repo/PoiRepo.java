package com.bae.persistence.repo;

import com.bae.persistence.domain.Poi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoiRepo extends JpaRepository<Poi, Long>{

}
