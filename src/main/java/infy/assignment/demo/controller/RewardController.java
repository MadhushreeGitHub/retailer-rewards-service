package infy.assignment.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import infy.assignment.demo.model.Customer;
import infy.assignment.demo.model.Record;
import infy.assignment.demo.services.RewardService;


@RestController
@RequestMapping("/customer")
public class RewardController {
    @Autowired
    private RewardService rewardService;
    private List<Customer> customers = new ArrayList<Customer>();

    @PostMapping("/record")
    public List<Customer> getCustomerRewardPoints(@RequestBody List<Record> recordList) {
        this.customers = rewardService.customerRewardCal(recordList);
        return this.customers;

    }

}
