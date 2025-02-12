package infy.assignment.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import infy.assignment.demo.model.Customer;
import infy.assignment.demo.model.Record;
import infy.assignment.demo.model.Transaction;
import static org.mockito.Mockito.*;
import infy.assignment.demo.services.RewardService;



public class RewardServiceTest {

  @InjectMocks
  private RewardService rewardService;

  @Mock
  private Record recordMock;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    rewardService = new RewardService();
  }

  @Test
  public void testCalculateRewardPoints() {
    assertEquals(0, rewardService.calculateRewardPoints(30));
    assertEquals(0, rewardService.calculateRewardPoints(50));
    assertEquals(25, rewardService.calculateRewardPoints(75));
    assertEquals(90, rewardService.calculateRewardPoints(120));
  }

  @Test
  public void testCustomerRewardCal() {
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

    List<Customer> result = rewardService.customerRewardCal(recordList);

    assertEquals(1, result.size());
    Customer resultCustomer = result.get(0);
    assertEquals("test@example.com", resultCustomer.getEmail());
    assertEquals(90, resultCustomer.getCustomerTotalReward());
    assertEquals(1, resultCustomer.getMonthWiseReward().size());
  }

  @Test
  public void testProcessRecord() {
    Customer customer = new Customer();
    customer.setEmail("test@example.com");
    customer.setMonthWiseReward(new HashMap<>());
    customer.setCustomerTotalReward(0);

    Transaction transaction = new Transaction();
    transaction.setTransactionAmount(120);
    transaction.setTransactionDate(java.util.Date.from(
        java.time.LocalDate.now().atStartOfDay(java.time.ZoneId.systemDefault()).toInstant()));

    when(recordMock.getCustomer()).thenReturn(customer);
    when(recordMock.getTransaction()).thenReturn(transaction);

    List<Record> recordList = new ArrayList<>();
    recordList.add(recordMock);

    List<Customer> result = rewardService.customerRewardCal(recordList);

    assertEquals(1, result.size());
    Customer resultCustomer = result.get(0);
    assertEquals("test@example.com", resultCustomer.getEmail());
    assertEquals(90, resultCustomer.getCustomerTotalReward());
    assertEquals(1, resultCustomer.getMonthWiseReward().size());
  }
}
