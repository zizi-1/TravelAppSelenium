package Test.service;

import com.bae.Service.PoiService;
import com.bae.exceptions.PoiNotFoundException;
import com.bae.persistence.domain.Poi;
import com.bae.persistence.repo.PoiRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
public class PoiServiceUnitTest {

    @InjectMocks
    private PoiService poiService;

    @Mock
    private PoiRepo poiRepo;

    private List<Poi> poiList;
    private Poi poi;
    private Poi poiId;
    final long id= 1L;

    @Before
    public void init() {
        this.poiList = new ArrayList<>();
        this.poiList.add(poi);
        this.poi = new Poi("Dubai poi 1", "dubai link");
        this.poiId = new Poi(poi.getPoiName(), poi.getLink());
        this.poiId.setId(id);
    }
    @Test
    public void getAllPoiTest() {
        when(poiRepo.findAll()).thenReturn(this.poiList);

        assertFalse("Controller has found no poi", this.poiService.getAllPoi().isEmpty());

        verify(poiRepo, times(1)).findAll();
    }

    @Test
    public void findPoiByIdTest() {
        when(this.poiRepo.findById(this.id)).thenReturn(Optional.of(this.poiId));

        assertEquals(this.poiId, this.poiService.findPoiById(this.id));

        verify(this.poiRepo, times(1)).findById(this.id);
    }

    @Test
    public void addNewPoiTest() {
        when(this.poiRepo.save(poi)).thenReturn(poiId);

        assertEquals(this.poiId, this.poiService.addNewPoi(poi));

        verify(this.poiRepo, times(1)).save(this.poi);
    }

    @Test
    public void updatePoiTest() {
        Poi newPoi = new Poi("name update test","link update test");
        Poi updatedPoi = new Poi(newPoi.getPoiName(), newPoi.getLink());
        updatedPoi.setId(this.id);

        when(this.poiRepo.findById(this.id)).thenReturn(Optional.of(this.poiId));
        when(this.poiRepo.save(updatedPoi)).thenReturn(updatedPoi);

        assertEquals(updatedPoi, this.poiService.updatePoi(this.id, newPoi));

        verify(this.poiRepo, times(1)).findById(1L);
        verify(this.poiRepo, times(1)).save(updatedPoi);

    }

    @Test
    public void deletePoiTest() throws PoiNotFoundException {
        when(this.poiRepo.existsById(id)).thenReturn(true);

        this.poiService.deletePoi(id);

        verify(this.poiRepo, times(1)).deleteById(id);
        verify(this.poiRepo, times(2)).existsById(id);
    }
}