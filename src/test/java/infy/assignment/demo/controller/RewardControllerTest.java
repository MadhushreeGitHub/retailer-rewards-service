package infy.assignment.demo.controller;


import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import com.fasterxml.jackson.databind.ObjectMapper;
import infy.assignment.demo.model.Customer;
import infy.assignment.demo.model.Record;
import infy.assignment.demo.model.Transaction;
import infy.assignment.demo.services.RewardService;

/**
 * Description: This class is a test class for RewardController.
 */

public class RewardControllerTest {
  private MockMvc mockMvc;

  @Mock
  private RewardService rewardService;

  @InjectMocks
  private RewardController rewardController;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(rewardController).build();
  }

  @Test
  public void testGetCustomerRewardPoints() throws Exception {
    List<Record> recordList = new ArrayList<>();
    Customer customer = new Customer();
    customer.setEmail("test@example.com");
    customer.setMonthWiseReward(new HashMap<>());
    customer.setCustomerTotalReward(0);

    Transaction transaction = new Transaction();
    transaction.setTransactionAmount(120);
    transaction.setTransactionDate(java.util.Date.from(
        java.time.LocalDate.now().atStartOfDay(java.time.ZoneId.systemDefault()).toInstant()));

    Record record = new Record();
    record.setCustomer(customer);
    record.setTransaction(transaction);

    recordList.add(record);

    List<Customer> customers = new ArrayList<>();
    customers.add(customer);

    when(rewardService.customerRewardCal(recordList)).thenReturn(customers);

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/customer/record").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(recordList)))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("test@example.com"))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].customerTotalReward").value(0))
        .andDo(MockMvcResultHandlers.print());
  }

}
