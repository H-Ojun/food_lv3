package food.infra;
import food.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class OrderStatusHateoasProcessor implements RepresentationModelProcessor<EntityModel<OrderStatus>>  {

    @Override
    public EntityModel<OrderStatus> process(EntityModel<OrderStatus> model) {

        
        return model;
    }
    
}
