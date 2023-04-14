package sam.springframework.spring6restmvc.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sam.springframework.spring6restmvc.entities.Beer;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
