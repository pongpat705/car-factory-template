package th.prior.training.car.showroom.model;

import lombok.Data;

@Data
public class AssembleRequestModel {
    private int orderId;
    private String orderCarType;
    private String buyerName;
}
