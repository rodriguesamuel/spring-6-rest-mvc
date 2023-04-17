package sam.springframework.spring6restmvc.respositories;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import sam.springframework.spring6restmvc.entities.Beer;
import sam.springframework.spring6restmvc.model.BeerStyle;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class BeerRepositoryTest {
    @Autowired
    BeerRepository beerRepository;

    @Test
    void name() {
    }

    @Test
    void testSaveBeerNameTooLong() {

        assertThrows(ConstraintViolationException.class, ()-> {
            Beer savedBeer = beerRepository.save(Beer.builder()
                    .beerName("My beer 142345678945612345678945612345678945612345678945612345678945641234567845612315456789")
                    .beerStyle(BeerStyle.PALE_ALE)
                    .upc("123123")
                    .price(new BigDecimal("11.44"))
                    .build());

            beerRepository.flush();
        });

    }

    @Test
    void testSaveBeer() {
        Beer savedBeer = beerRepository.save(Beer.builder()
                .beerName("My beer")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("123123")
                .price(new BigDecimal("11.44"))
                .build());

        beerRepository.flush();

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }
}