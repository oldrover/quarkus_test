import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class ReactiveFruitService {

    @Inject
    ReactiveFruitDao reactiveFruitDao;

    public Uni<Void> add(Fruit fruit) {
        return reactiveFruitDao.update(fruit);
    } 

    public Multi<Fruit> getAll() {
        return reactiveFruitDao.findAll();
    }
    
}
