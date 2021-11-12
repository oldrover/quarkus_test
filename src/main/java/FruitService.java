import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FruitService {

  @Inject FruitDao fruitDao;

  public void save(Fruit fruit) {
    fruitDao.update(fruit);
  }

  public List<Fruit> getAll() {
    return fruitDao.findAll().all();
  }
}
