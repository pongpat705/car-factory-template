package th.prior.training.car.factory.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TypeCarInfoModel {

    private int typeId;
    private String typeGroup;
    private String typePart;
    private int typeAmount;
    private LocalDateTime typeCreateDate;
    private String isActive;
}
