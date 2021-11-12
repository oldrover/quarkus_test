import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.Select;
import com.datastax.oss.driver.api.mapper.annotations.Update;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@Dao
public interface ReactiveFruitDao {

    @Update
    Uni<Void> update(Fruit fruit);

    @Select
    Multi<Fruit> findAll();

    
    
}
