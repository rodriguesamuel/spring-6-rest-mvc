package sam.springframework.spring6restmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import sam.springframework.spring6restmvc.entities.Beer;
import sam.springframework.spring6restmvc.model.BeerDTO;
import sam.springframework.spring6restmvc.respositories.BeerRepository;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerControllerIT {
    @Autowired
    BeerController controller;
    @Autowired
    BeerRepository repository;

    @Test
    void testBeerIdNotFound() {
        assertThrows(NotFoundException.class, () -> {
            controller.getBeerById(UUID.randomUUID());
        });
    }

    @Test
    void testGetById() {
        Beer beer = repository.findAll().get(0);

        BeerDTO dto = controller.getBeerById(beer.getId());

        assertThat(dto).isNotNull();
    }

    @Test
    void testListBeers() {
        List<BeerDTO> dtos = controller.listBeer();

        assertThat(dtos.size()).isEqualTo(3);
    }

    @Rollback
    @Transactional
    @Test
    void testEmptyList() {
        repository.deleteAll();
        List<BeerDTO> dtos = controller.listBeer();

        assertThat(dtos.size()).isEqualTo(0);
    }
}