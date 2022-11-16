package th.prior.training.car.showroom.component.io;

public interface BaseAPIComponent<T,R> {

    R call(T request);

}
