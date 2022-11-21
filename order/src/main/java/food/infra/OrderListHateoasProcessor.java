package food.infra;
import food.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class OrderListHateoasProcessor implements RepresentationModelProcessor<EntityModel<OrderList>>  {

    @Override
    public EntityModel<OrderList> process(EntityModel<OrderList> model) {

        
        return model;
    }
    
}
