package Test.rest;

import com.bae.Rest.PoiController;
import com.bae.Service.PoiService;
import com.bae.exceptions.PoiNotFoundException;
import com.bae.persistence.domain.Poi;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class PoiControllerUnitTest {

    @InjectMocks
    private PoiController poiController;

    @Mock
    private PoiService poiService;

    private List<Poi> poiList;
    private Poi poi;
    private Poi poiId;
    final long id = 1L;

    @Before
    public void init() {
        this.poiList = new ArrayList<>();
        this.poiList.add(poi);
        this.poi = new Poi("Dubai poi 1", "dubai link");
        this.poiId = new Poi(poi.getPoiName(), poi.getLink());
        this.poiId.setId(id);
    }

    @Test
    public void getAllPoiTest() throws PoiNotFoundException {
        when(poiService.getAllPoi()).thenReturn(this.poiList);

        assertFalse("Controller has found no poi", this.poiController.getAllPoi().isEmpty());

        verify(poiService, times(1)).getAllPoi();
    }

    @Test
    public void getPoiTest() throws PoiNotFoundException {
        when(this.poiService.findPoiById(this.id)).thenReturn(this.poiId);

        assertEquals(this.poiId, this.poiController.getPoi(this.id));

        verify(this.poiService, times(1)).findPoiById(this.id);
    }

    @Test
    public void addPoiTest() {
        when(this.poiService.addNewPoi(poi)).thenReturn(poiId);

        assertEquals(this.poiId, this.poiController.addPoi(poi));

        verify(this.poiService, times(1)).addNewPoi(this.poi);
    }

    @Test
    public void updatePoiTest() throws PoiNotFoundException{
        Poi newPoi = new Poi("updated name.", "updated link");
        Poi updatedPoi = new Poi(newPoi.getPoiName(), newPoi.getLink());
        updatedPoi.setId(this.id);

        when(this.poiService.updatePoi(this.id, newPoi)).thenReturn(updatedPoi);

        assertEquals(updatedPoi, this.poiController.updatePoi(this.id, newPoi));

        verify(this.poiService, times(1)).updatePoi(this.id, newPoi);

    }

    @Test
    public void deletePoiTest() throws PoiNotFoundException {
        this.poiController.deletePoi(id);

        verify(this.poiService, times(1)).deletePoi(id);
    }
}