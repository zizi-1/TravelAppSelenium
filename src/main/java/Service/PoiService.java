package Service;

import java.util.List;

import org.springframework.stereotype.Service;

import persistence.domain.Poi;
import persistence.repo.DetailsRepo;
import persistence.repo.PoiRepo;

@Service
public class PoiService {

	private PoiRepo poiRepo;

	public PoiService(PoiRepo poiRepo) {
		this.poiRepo = poiRepo;
	}

	public List<Poi> getAllPoi() {
		if (poiRepo.findAll().isEmpty()) {
			setUpPoi();
		}
		return poiRepo.findAll();
	}

	private void setUpPoi() {
		Poi p1 = new Poi("name", "link");
		this.poiRepo.save(p1);
	}

	public Poi addNewPoi(Poi p) {
		return poiRepo.save(p);
	}

	public Poi updatePoi(Poi p) {
		return poiRepo.save(p);
	}

	public String deletePoi(Long id) {
		poiRepo.deleteById(id);
		return "Poi deleted succesfully";
	}
}
