package sam.springframework.spring6restmvc.mappers;

import org.mapstruct.Mapper;
import sam.springframework.spring6restmvc.entities.Customer;
import sam.springframework.spring6restmvc.model.CustomerDTO;

@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDTO dto);
    CustomerDTO customerToCustomerDto(Customer customer);
}
