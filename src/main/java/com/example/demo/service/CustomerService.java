package com.example.demo.service;

import com.example.demo.dao.CustomerDao;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;
    public Customer addCustomer(Customer customer){
        return customerDao.save(customer);
    }
    public List<Customer> getCustomerList(){
       return customerDao.findAll();
    }
    public Customer getCustomer(int customerId){
        Optional<Customer> op=customerDao.findById(customerId);
        if(!op.isPresent())
            throw new CustomerNotFoundException("customer not found with given id");
        return op.get();
    }
    public Customer updateCustomer(int customerId,Customer customer){
        customer.setCustomerId(customerId);
        return customerDao.save(customer);
    }
    public void deleteCustomer(int customerId){
        customerDao.deleteById(customerId);
    }
}

