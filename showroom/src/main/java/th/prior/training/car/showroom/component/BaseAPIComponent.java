package th.prior.training.car.showroom.component;

public interface BaseAPIComponent<T,R> {

    R call(T request);

}
