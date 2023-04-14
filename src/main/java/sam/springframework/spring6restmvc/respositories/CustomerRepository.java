package sam.springframework.spring6restmvc.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sam.springframework.spring6restmvc.entities.Customer;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
