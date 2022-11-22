package food.infra;

import food.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="payInfos", path="payInfos")
public interface PayInfoRepository extends PagingAndSortingRepository<PayInfo, Long> {

    List<PayInfo> findByOrderId(String orderId);


    
}
