package food.infra;

import food.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="onDeliveryInfos", path="onDeliveryInfos")
public interface OnDeliveryInfoRepository extends PagingAndSortingRepository<OnDeliveryInfo, Long> {

    List<OnDeliveryInfo> findByOrderId(String orderId);


    
}
