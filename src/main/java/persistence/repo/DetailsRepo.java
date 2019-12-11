package persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import persistence.domain.Details;

public interface DetailsRepo extends JpaRepository<Details, Long> {


}
