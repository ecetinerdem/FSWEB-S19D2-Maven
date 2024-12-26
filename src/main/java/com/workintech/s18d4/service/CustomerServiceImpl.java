package com.workintech.s18d4.service;


import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.exceptions.CustomerException;
import com.workintech.s18d4.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer find(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerException("Customer with given id does not exist " + id, HttpStatus.NOT_FOUND));
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer delete(Long id) {
        Customer toBeDeleted = find(id);
        customerRepository.delete(toBeDeleted);
        return toBeDeleted;
    }
}
