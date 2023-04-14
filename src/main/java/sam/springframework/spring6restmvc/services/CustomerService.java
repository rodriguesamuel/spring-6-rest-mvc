package sam.springframework.spring6restmvc.services;

import sam.springframework.spring6restmvc.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
    List<Customer> listCustomers();

    Optional<Customer> getCustomerById(UUID id);

    Customer saveNewCustomer(Customer customer);

    void updateCustomerById(UUID customerId, Customer customer);

    void deleteById(UUID customerId);

    void patchCustomerBydId(UUID customerId, Customer customer);
}
