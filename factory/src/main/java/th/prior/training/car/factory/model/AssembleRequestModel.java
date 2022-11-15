package th.prior.training.car.factory.model;

import lombok.Data;

@Data
public class AssembleRequestModel {
    private int orderId;
    private String orderCarType;
    private String buyerName;
}
