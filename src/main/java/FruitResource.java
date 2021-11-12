import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;

@Path("/fruits")
@Produces({MediaType.APPLICATION_JSON})
@Consumes(MediaType.APPLICATION_JSON)
public class FruitResource {

  @Inject FruitService fruitService;

  @Inject MeterRegistry meterRegistry;

  @GET
  @Path("/hello")
  public String hello() {
    return "hello";
  }

  @GET
  public List<FruitDto> getAll() {
    return fruitService.getAll().stream().map(this::convertToDto).collect(Collectors.toList());
  }

  @POST
  public void add(FruitDto fruitDto) {
    meterRegistry.counter("fruit_add_counter", Tags.of("fruit", fruitDto.getName())).increment();
    fruitService.save(convertFromDto(fruitDto));
  }

  private FruitDto convertToDto(Fruit fruit) {
    return new FruitDto(fruit.getName(), fruit.getDescription());
  }

  private Fruit convertFromDto(FruitDto fruitDto) {
    return new Fruit(fruitDto.getName(), fruitDto.getDescription());
  }
}
