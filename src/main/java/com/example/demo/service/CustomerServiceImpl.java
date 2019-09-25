package com.example.demo.service;


import com.example.demo.model.CustomerDto;
import com.example.demo.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static com.example.demo.repository.CustomerRepository.customerMap;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    final java.util.Random rand = new java.util.Random();
    final Set<String> identifiers = new HashSet<String>();

    @Autowired
    CustomerRepository customerRepository;
    int lastId = 5;

    public String randomIdentifier() {
        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt(5) + 5;
            for (int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if (identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }


    @Override
    public Collection<CustomerDto> getCustomer() {
        logger.info("getCustomer.start");
        Collection<CustomerDto> valueOfMap = customerMap.values();
        logger.info("getCustomer.end");
        return valueOfMap;
    }

    @Override
    public void addCustomer(CustomerDto customerDto) {
        logger.info("addCustomer.start");
        customerDto.setId(lastId);
        customerMap.put(lastId, customerDto);
        lastId++;
        logger.info("addCustomer.end");
    }

    @Scheduled(fixedRate = 5000)
    public void addCustomerInFiveSecond() {
        logger.info("addCustomerInFiveSecond.start");
        CustomerDto customerDto2 = new CustomerDto();
        String name = randomIdentifier();
        System.out.println(name);
        customerDto2.setName(name);
        customerDto2.setId(lastId);
        customerMap.put(lastId, customerDto2);
        lastId++;
        logger.info("addCustomerInFiveSecond.end");
    }


    @Override
    public void updateCustomer(int id, CustomerDto customerDto) {
        logger.info("updateCustomer.start");
        customerMap.remove(id);
        customerDto.setId(id);
        customerMap.put(id, customerDto);
        logger.info("updateCustomer.end");
    }

    @Override
    public void deleteCustomer(int id) {
        customerMap.remove(id);
    }
}
