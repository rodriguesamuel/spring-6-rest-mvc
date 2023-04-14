package sam.springframework.spring6restmvc.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sam.springframework.spring6restmvc.entities.Beer;
import sam.springframework.spring6restmvc.entities.Customer;
import sam.springframework.spring6restmvc.model.BeerStyle;
import sam.springframework.spring6restmvc.respositories.BeerRepository;
import sam.springframework.spring6restmvc.respositories.CustomerRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static com.fasterxml.jackson.databind.type.LogicalType.Array;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {
    private final BeerRepository beerRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {

        loadBeer();

        loadCustomer();

        System.out.println("In bootstrap");
        System.out.println("Beer Count: " + beerRepository.count());
        System.out.println("customer Count: " + customerRepository.count());
    }

    private void loadBeer() {
        if (beerRepository.count() == 0) {
            Beer beer1 = Beer.builder()
                    .beerName("Brahma")
                    .beerStyle(BeerStyle.GOSE)
                    .upc("1234")
                    .createdDate(LocalDateTime.now())
                    .price(BigDecimal.valueOf(12.5))
                    .updateDate(LocalDateTime.now())
                    .quantityOnHand(250)
                    .build();

            Beer beer2 = Beer.builder()
                    .beerName("Skol")
                    .beerStyle(BeerStyle.LAGER)
                    .upc("4321")
                    .createdDate(LocalDateTime.now())
                    .price(BigDecimal.valueOf(11.5))
                    .updateDate(LocalDateTime.now())
                    .quantityOnHand(150)
                    .build();

            Beer beer3 = Beer.builder()
                    .beerName("Itaipava")
                    .beerStyle(BeerStyle.ALE)
                    .upc("4567")
                    .createdDate(LocalDateTime.now())
                    .price(BigDecimal.valueOf(8.5))
                    .updateDate(LocalDateTime.now())
                    .quantityOnHand(350)
                    .build();


            beerRepository.saveAll(Arrays.asList(beer1, beer2, beer3));
        }
    }

    private void loadCustomer() {
        if (customerRepository.count() == 0) {
            Customer customer1 = Customer.builder()
                    .customerName("Pedro")
                    .createdDate(LocalDateTime.now())
                    .lastModifiedDate(LocalDateTime.now())
                    .build();

            Customer customer2 = Customer.builder()
                    .customerName("Tiago")
                    .createdDate(LocalDateTime.now())
                    .lastModifiedDate(LocalDateTime.now())
                    .build();

            Customer customer3 = Customer.builder()
                    .customerName("João")
                    .createdDate(LocalDateTime.now())
                    .lastModifiedDate(LocalDateTime.now())
                    .build();

            customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));
        }
    }
}
