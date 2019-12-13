package persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import persistence.domain.Poi;

public interface PoiRepo extends JpaRepository<Poi, Long>{

}
