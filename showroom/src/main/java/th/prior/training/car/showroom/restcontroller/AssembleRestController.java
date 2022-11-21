package th.prior.training.car.showroom.restcontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import th.prior.training.car.showroom.model.ResponseModel;
import th.prior.training.car.showroom.service.ShowroomService;

@Slf4j
@RestController
@RequestMapping("/api")
public class AssembleRestController {

    private ShowroomService showroomService;

    public AssembleRestController(ShowroomService showroomService) {
        this.showroomService = showroomService;
    }

    @GetMapping("/assemble/{orderId}")
    public ResponseModel<Void> assemble(@PathVariable String orderId){
        log.info("assemble by id {}", orderId);
        return this.showroomService.assembleACar(orderId);
    }
}
