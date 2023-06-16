package id.parkee.test.test.controller;

import id.parkee.test.common.model.enums.ParkeeErrorCode;
import id.parkee.test.common.model.result.ticket.CheckInResult;
import id.parkee.test.common.model.result.ticket.TicketInfoResult;
import id.parkee.test.test.base.ParkeeTestBase;
import id.parkee.test.test.util.ResultAssert;
import id.parkee.test.web.controller.TicketController;
import id.parkee.test.web.form.ticket.CheckInForm;
import id.parkee.test.web.form.ticket.TicketInfoForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TicketControllerTest extends ParkeeTestBase {
    @Autowired
    private TicketController ticketController;

    @Test
    public void checkInTest_SUCCESS() {
        CheckInForm form = new CheckInForm();
        form.setVehicleType("MOTOR");
        form.setAreaCode("B");
        form.setPlateNumber("1234");
        form.setPlateCode("BCD");

        CheckInResult result = ticketController.checkIn(form).getBody();
        ResultAssert.isSuccess(result.isSuccess());
    }

    @Test
    public void checkInTest_FAILED_PARAMILLEGAL() {
        CheckInForm form = new CheckInForm();
        form.setVehicleType("MOTOR");
        form.setAreaCode("B");
        form.setPlateNumber("A234");
        form.setPlateCode("AB");

        CheckInResult result = ticketController.checkIn(form).getBody();
        ResultAssert.isNotSuccess(result.isSuccess());
        ResultAssert.isExpected(result.getResultCode(),
                ParkeeErrorCode.PARAM_ILLEGAL.getErrorCode());
    }

    @Test
    public void checkInTest_FAILED_EXIST() {
        CheckInForm form = new CheckInForm();
        form.setVehicleType("MOTOR");
        form.setAreaCode("B");
        form.setPlateNumber("1234");
        form.setPlateCode("AB");

        CheckInResult result = ticketController.checkIn(form).getBody();
        ResultAssert.isNotSuccess(result.isSuccess());
        ResultAssert.isExpected(result.getResultCode(),
                ParkeeErrorCode.SIMILAR_PLATE_FOUND.getErrorCode());
    }

    @Test
    public void ticketInfo_SUCCESS() {
        TicketInfoForm form = new TicketInfoForm();
        form.setTicketNumber("30984");

        TicketInfoResult result = ticketController.info(form).getBody();
        ResultAssert.isSuccess(result.isSuccess());
    }

    @Test
    public void ticketInfo_FAILED_notFound() {
        TicketInfoForm form = new TicketInfoForm();
        form.setTicketNumber("30985");

        TicketInfoResult result = ticketController.info(form).getBody();
        ResultAssert.isExpected(result.getResultCode(),
                ParkeeErrorCode.TICKET_NOT_FOUND.getErrorCode());
    }
}
