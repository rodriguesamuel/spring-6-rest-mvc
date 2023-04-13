package sam.springframework.spring6restmvc.services;

import sam.springframework.spring6restmvc.model.Beer;
import sam.springframework.spring6restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<Customer> listCustomers();

    Customer getcustomerById(UUID id);
}
