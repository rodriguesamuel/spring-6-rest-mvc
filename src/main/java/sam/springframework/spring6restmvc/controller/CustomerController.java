package sam.springframework.spring6restmvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sam.springframework.spring6restmvc.model.Customer;
import sam.springframework.spring6restmvc.services.CustomerService;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CustomerController {
    public static final String CUSTOMER_PATH = "/api/v1/customer";
    public static final String CUSTOMER_PATH_ID = CUSTOMER_PATH + "/{customerId}";
    private final CustomerService customerService;

    @PatchMapping(CUSTOMER_PATH_ID)
    public ResponseEntity updateCustumerPatchById(@PathVariable("customerId") UUID customerId, @RequestBody Customer customer){

        customerService.patchCustomerBydId(customerId, customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(CUSTOMER_PATH_ID)
    public ResponseEntity deleteById(@PathVariable("customerId") UUID customerId) {

        customerService.deleteById(customerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(CUSTOMER_PATH_ID)
    public ResponseEntity updateById(@PathVariable("customerId") UUID customerId, @RequestBody Customer customer) {

        customerService.updateCustomerById(customerId, customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(CUSTOMER_PATH)
    public ResponseEntity handlePost(@RequestBody Customer customer) {

        Customer savedCustomer = customerService.saveNewCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + savedCustomer.getId());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @GetMapping(CUSTOMER_PATH)
    public List<Customer> listCustomers() {

        log.debug("List customers - in controller");

        return customerService.listCustomers();
    }

    @RequestMapping(CUSTOMER_PATH_ID)
    public Customer getCustomerById(@PathVariable("customerId") UUID customerId) {
        return customerService.getCustomerById(customerId).orElseThrow(NotFoundException::new);
    }
}
