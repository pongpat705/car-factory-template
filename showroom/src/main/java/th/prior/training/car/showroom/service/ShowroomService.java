package th.prior.training.car.showroom.service;

import org.springframework.stereotype.Service;
import th.prior.training.car.showroom.component.BaseAPIComponent;
import th.prior.training.car.showroom.model.ProduceableRequestModel;
import th.prior.training.car.showroom.model.ProduceableResponseModel;

@Service
public class ShowroomService {

    private BaseAPIComponent<ProduceableRequestModel, ProduceableResponseModel> produceableApiComponent;

    public ShowroomService(BaseAPIComponent<ProduceableRequestModel, ProduceableResponseModel> produceableApiComponent) {
        this.produceableApiComponent = produceableApiComponent;
    }

    public void buyingACar(){

        ProduceableRequestModel produceableRequestModel = new ProduceableRequestModel();
        ProduceableResponseModel produceableResponseModel = this.produceableApiComponent.call(produceableRequestModel);
        this.shouldTellBuyer(produceableResponseModel);
    }

    public boolean shouldTellBuyer(ProduceableResponseModel produceableResponseModel){
        boolean result = false;

        if(produceableResponseModel.isProduce()){
            result = true;
        }

        return result;
    }
}
