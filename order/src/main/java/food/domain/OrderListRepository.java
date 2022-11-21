package food.domain;

import food.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="orderLists", path="orderLists")
public interface OrderListRepository extends PagingAndSortingRepository<OrderList, Long>{

}
