package com.example.demo.repository;

import com.example.demo.model.CustomerDto;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Getter
@Setter
@Repository
public class CustomerRepository {

    public static HashMap<Integer, CustomerDto> customerMap = new HashMap<>();

    private static final Logger logger = LoggerFactory.getLogger(CustomerRepository.class);

    static {
        CustomerDto customerDto1 = new CustomerDto();
        customerDto1.setId(1);
        customerDto1.setName("Faxri");
        customerMap.put(customerDto1.getId(), customerDto1);

        CustomerDto customerDto2 = new CustomerDto();
        customerDto2.setId(2);
        customerDto2.setName("Namiq");
        customerMap.put(customerDto2.getId(), customerDto2);

        CustomerDto customerDto3 = new CustomerDto();
        customerDto3.setId(3);
        customerDto3.setName("Kamal");
        customerMap.put(customerDto3.getId(), customerDto3);

        CustomerDto customerDto4 = new CustomerDto();
        customerDto4.setId(4);
        customerDto4.setName("Mammad");
        customerMap.put(customerDto4.getId(), customerDto4);
    }
}
