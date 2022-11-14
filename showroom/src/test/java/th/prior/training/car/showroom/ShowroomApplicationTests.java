package th.prior.training.car.showroom;


import org.junit.jupiter.api.Assertions;
import th.prior.training.car.showroom.component.FactoryProduceableClientComponentTest;
import th.prior.training.car.showroom.model.ProduceableResponseModel;
import th.prior.training.car.showroom.service.ShowroomService;

class ShowroomApplicationTests {


	public void shouldResponseToBuyerWaitOrNoWait(){
		FactoryProduceableClientComponentTest factoryProduceableClientComponentTest = new FactoryProduceableClientComponentTest();
		ProduceableResponseModel produceableResponseModel = factoryProduceableClientComponentTest.call(null);

		ShowroomService showroomService = new ShowroomService(factoryProduceableClientComponentTest);

		boolean result = showroomService.shouldTellBuyer(produceableResponseModel);

		Assertions.assertEquals(true, result);


	}


}
