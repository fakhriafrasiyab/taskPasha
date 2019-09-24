package com.example.demo.service;

import com.example.demo.model.CustomerDto;

import java.util.Collection;

public interface CustomerService {
    public abstract Collection<CustomerDto> getCustomer();

    public abstract void addCustomer(CustomerDto customerDto);

    public abstract void updateCustomer(int id, CustomerDto customerDto);

    public abstract void deleteCustomer(int id);

    public void addCustomerInFiveSecond();
}
