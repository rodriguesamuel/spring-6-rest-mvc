package sam.springframework.spring6restmvc.mappers;

import org.mapstruct.Mapper;
import sam.springframework.spring6restmvc.entities.Beer;
import sam.springframework.spring6restmvc.model.BeerDTO;

@Mapper
public interface BeerMapper {
    Beer beerDtoToBeer(BeerDTO dto);
    BeerDTO beerToBeerDto(Beer beer);
}
