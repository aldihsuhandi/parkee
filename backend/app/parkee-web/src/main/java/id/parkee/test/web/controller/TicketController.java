package id.parkee.test.web.controller;

import id.parkee.test.common.model.enums.ProcessTypeEnum;
import id.parkee.test.common.model.request.ticket.CheckInRequest;
import id.parkee.test.common.model.result.ticket.CheckInResult;
import id.parkee.test.web.callback.ControllerCallback;
import id.parkee.test.web.callback.ControllerCallbackSupport;
import id.parkee.test.web.form.ticket.CheckInForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parkee/ticket")
public class TicketController extends BaseController {
    @PostMapping("/in")
    public ResponseEntity<CheckInResult> checkIn(@RequestBody CheckInForm form) {
        return ControllerCallbackSupport.process(ProcessTypeEnum.CHECKED_IN.getCode(), form, new ControllerCallback<CheckInRequest, CheckInResult>() {
            @Override
            public CheckInResult initResult() {
                return new CheckInResult();
            }

            @Override
            public CheckInRequest composeRequest() {
                CheckInRequest request = new CheckInRequest();
                request.setAreaCode(form.getAreaCode());
                request.setPlateCode(form.getPlateCode());
                request.setPlateNumber(form.getPlateNumber());
                request.setVehicleType(form.getVehicleType());

                return request;
            }

            @Override
            public void process(String processType, CheckInRequest request, CheckInResult result) {
                doProcess(processType, request, result);
            }
        });
    }
}