package infy.assignment.retailer.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import infy.assignment.retailer.model.Customer;
import infy.assignment.retailer.model.Record;
import infy.assignment.retailer.model.Transaction;
import infy.assignment.retailer.services.RewardService;

@SpringBootTest
@AutoConfigureMockMvc
public class RewardControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RewardService rewardService;

    private List<Record> recordList;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        recordList = new ArrayList<>();
        customer = new Customer();
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
    }

    @Test
    public void testGetCustomerRewardPoints() throws Exception {
        mockMvc.perform(post("/customer/record")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(recordList)))
            .andExpect(status().isOk())
            .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testGetCustomerRewardPointsForMultipleTransactions() throws Exception {
        Transaction transaction1 = new Transaction();
        transaction1.setTransactionAmount(50);
        transaction1.setTransactionDate(java.util.Date.from(
            java.time.LocalDate.now().minusDays(1).atStartOfDay(java.time.ZoneId.systemDefault()).toInstant()));

        Transaction transaction2 = new Transaction();
        transaction2.setTransactionAmount(200);
        transaction2.setTransactionDate(java.util.Date.from(
            java.time.LocalDate.now().minusDays(2).atStartOfDay(java.time.ZoneId.systemDefault()).toInstant()));

        Record record1 = new Record();
        record1.setCustomer(customer);
        record1.setTransaction(transaction1);

        Record record2 = new Record();
        record2.setCustomer(customer);
        record2.setTransaction(transaction2);

        List<Record> multipleRecords = new ArrayList<>();
        multipleRecords.add(record1);
        multipleRecords.add(record2);

        mockMvc.perform(post("/customer/record")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(multipleRecords)))
            .andExpect(status().isOk())
            .andDo(MockMvcResultHandlers.print());
    }

}