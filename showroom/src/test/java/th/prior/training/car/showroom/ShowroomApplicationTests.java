package th.prior.training.car.showroom;

import th.prior.training.car.showroom.component.io.BaseAPIComponent;
import th.prior.training.car.showroom.component.FactoryProduceableClientComponentTest;
import th.prior.training.car.showroom.model.ProduceableRequestModel;
import th.prior.training.car.showroom.model.ProduceableResponseModel;
import th.prior.training.car.showroom.service.ShowroomService;

class ShowroomApplicationTests {


	public void shouldResponseToBuyerWaitOrNoWait(){

		FactoryProduceableClientComponentTest
				factoryProduceableClientComponentTest = new FactoryProduceableClientComponentTest();

		ProduceableResponseModel produceableResponseModel = factoryProduceableClientComponentTest.call(null);

		ShowroomService showroomService = new ShowroomService(factoryProduceableClientComponentTest
				, null
				, null, null);

		boolean result = showroomService.shouldTellBuyer(produceableResponseModel);

//		Assertions.assertEquals(true, result);


	}


//	@Test
	public void testGetEnvironmentVariable(){
		String val = System.getenv("USERNAME");

		System.out.println(val);
	}


}
