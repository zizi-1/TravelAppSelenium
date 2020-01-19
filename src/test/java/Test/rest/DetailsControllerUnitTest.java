package Test.rest;

import com.bae.Rest.DetailsController;
import com.bae.Service.DetailsService;
import com.bae.persistence.domain.Details;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class DetailsControllerUnitTest {

    @InjectMocks
    private DetailsController detailsController;

    @Mock
    private DetailsService detailsService;

    private List<Details> detailsList;
    private Details detail;
    private Details detailId;
    final long id =1L;

    @Before
    public void init(){
        this.detailsList = new ArrayList<>();
        this.detailsList.add(detail);
        this.detail = new Details("Glasgow","Manchester", new Date(),new Date());
        this.detailId = new Details(detail.getOrigin(), detail.getDestination(), detail.getDateFrom(), detail.getDateTo());
        this.detailId.setId(id);
    }

    @Test
    public void getAllDetailsTest(){
        when(this.detailsService.readDetails()).thenReturn(this.detailsList);

        assertFalse("Controller has found no details", this.detailsController.getAllDetails().isEmpty());

        verify(this.detailsService, times(1)).readDetails();
    }

    @Test
    public void getDetailsTest(){
        when(this.detailsService.findDetailsByID(this.id)).thenReturn(this.detailId);

        assertEquals(this.detailId, this.detailsController.getDetails(this.id));

        verify(this.detailsService, times(1)).findDetailsByID(this.id);
    }

    @Test
    public void addDetailsTest() {
        when(this.detailsService.addNewDetails(detail)).thenReturn(detailId);

        assertEquals(this.detailId, this.detailsController.addNewDetails(detail));

        verify(this.detailsService, times(1)).addNewDetails(this.detail);
    }

    @Test
    public void updateDetailsTest() {
        Details newDetails = new Details("Dubai","London",new Date(),new Date());
        Details updatedDetails = new Details(newDetails.getOrigin(), newDetails.getDestination(), newDetails.getDateFrom() ,newDetails.getDateTo());
        updatedDetails.setId(this.id);

        when(this.detailsService.updateDetails(this.id, newDetails)).thenReturn(updatedDetails);

        assertEquals(updatedDetails, this.detailsController.updateDetails(this.id, newDetails));

        verify(this.detailsService, times(1)).updateDetails(this.id, newDetails);

    }

    @Test
    public void deleteDetailTest() {
        this.detailsController.deleteDetails(id);

        verify(this.detailsService, times(1)).deleteDetails(id);
    }

}
