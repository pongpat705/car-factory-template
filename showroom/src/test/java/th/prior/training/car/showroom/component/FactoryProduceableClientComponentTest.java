package th.prior.training.car.showroom.component;

import th.prior.training.car.showroom.component.io.BaseAPIComponent;
import th.prior.training.car.showroom.model.ProduceableRequestModel;
import th.prior.training.car.showroom.model.ProduceableResponseModel;

public class FactoryProduceableClientComponentTest implements BaseAPIComponent<ProduceableRequestModel, ProduceableResponseModel> {

    @Override
    public ProduceableResponseModel call(ProduceableRequestModel request) {
        ProduceableResponseModel result = new ProduceableResponseModel();
        result.setProduce(true);
        return result;
    }
}
