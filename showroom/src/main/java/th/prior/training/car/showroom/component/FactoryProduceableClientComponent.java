package th.prior.training.car.showroom.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import th.prior.training.car.showroom.model.ProduceableRequestModel;
import th.prior.training.car.showroom.model.ProduceableResponseModel;

@Component
public class FactoryProduceableClientComponent implements BaseAPIComponent<ProduceableRequestModel, ProduceableResponseModel> {


    @Value("${app.rest.factory.is-produce.url}")
    private String serviceUrl;

    @Override
    public ProduceableResponseModel call(ProduceableRequestModel request) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProduceableResponseModel> response
                = restTemplate.postForEntity(this.serviceUrl, request, ProduceableResponseModel.class);
        return response.getBody();
    }
}
