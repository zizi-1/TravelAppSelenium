package Test.service;

import com.bae.Service.DetailsService;
import com.bae.exceptions.DetailsNotFoundException;
import com.bae.persistence.domain.Details;

import com.bae.persistence.repo.DetailsRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class DetailsServiceUnitTest {

    @InjectMocks
    private DetailsService detailsService;

    @Mock
    private DetailsRepo detailsRepo;
    private List<Details> detailsList;
    private Details details;
    private Details detailsId;
    final long id = 1L;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date testDateTo = new Date();

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date testDateFrom = new Date();

    @Before
    public void init() {
        this.detailsList = new ArrayList<>();

        this.details = new Details("Dubai","London",testDateTo,testDateFrom);
        this.detailsList.add(details);
        this.detailsId = new Details(details.getOrigin(), details.getDestination(), details.getDateFrom(), details.getDateTo());
        this.detailsId.setId(id);
    }

    @Test
    public void getAllDetailsTest() {
        Mockito.when(detailsRepo.findAll()).thenReturn(detailsList);
        detailsService.readDetails();
        verify(detailsRepo, times(1)).findAll();
    }

    @Test
    public void findDetailByIdTest() throws DetailsNotFoundException {
        when(this.detailsRepo.findById(this.id)).thenReturn(Optional.of(this.detailsId));

        assertEquals(this.detailsId, this.detailsService.findDetailsByID(this.id));

        verify(this.detailsRepo, times(1)).findById(this.id);
    }

    @Test
    public void addDetailsTest() {
        when(this.detailsRepo.save(details)).thenReturn(detailsId);

        assertEquals(this.detailsId, this.detailsService.addNewDetails(details));

        verify(this.detailsRepo, times(1)).save(this.details);
    }

    @Test
    public void deleteDetailTest() throws DetailsNotFoundException {
        when(this.detailsRepo.existsById(id)).thenReturn(true);

        this.detailsService.deleteDetails(id);

        verify(this.detailsRepo, times(1)).deleteById(id);
        verify(this.detailsRepo, times(2)).existsById(id);
    }

    @Test
    public void updateDetailsTest() {
        Details newDetails = new Details("Thailand","Berlin", testDateFrom, testDateTo);
        Details updatedDetails = new Details(newDetails.getOrigin(), newDetails.getDestination(), newDetails.getDateFrom(), newDetails.getDateTo());
        updatedDetails.setId(this.id);

        when(this.detailsRepo.findById(this.id)).thenReturn(Optional.of(this.detailsId));
        when(this.detailsRepo.save(updatedDetails)).thenReturn(updatedDetails);

        assertEquals(updatedDetails, this.detailsService.updateDetails(this.id, newDetails));

        verify(this.detailsRepo, times(1)).findById(1L);
        verify(this.detailsRepo, times(1)).save(updatedDetails);
    }



}
