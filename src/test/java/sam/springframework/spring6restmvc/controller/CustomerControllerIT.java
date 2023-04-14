package sam.springframework.spring6restmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import sam.springframework.spring6restmvc.entities.Customer;
import sam.springframework.spring6restmvc.model.CustomerDTO;
import sam.springframework.spring6restmvc.respositories.CustomerRepository;
import sam.springframework.spring6restmvc.services.CustomerService;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerControllerIT {
    @Autowired
    CustomerController controller;
    @Autowired
    CustomerRepository repository;

    @Rollback
    @Transactional
    @Test
    void testListAllEmptyList() {
        repository.deleteAll();

        List<CustomerDTO> dtos = controller.listCustomers();

        assertThat(dtos.size()).isEqualTo(0);
    }

    @Test
    void testListAll() {
        List<CustomerDTO> dtos = controller.listCustomers();

        assertThat(dtos.size()).isEqualTo(3);
    }

    @Test
    void testGetByIdNotFound() {
        assertThrows(NotFoundException.class, () -> {
            controller.getCustomerById(UUID.randomUUID());
        });
    }

    @Test
    void testGetById() {
        Customer customer = repository.findAll().get(0);
        CustomerDTO customerDTO = controller.getCustomerById(customer.getId());
        assertThat(customerDTO).isNotNull();
    }
}