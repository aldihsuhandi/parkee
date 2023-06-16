package id.parkee.test.core.processor.ticket;

import id.parkee.test.common.model.enums.ParkeeErrorCode;
import id.parkee.test.common.model.request.BaseRequest;
import id.parkee.test.common.model.request.ticket.TicketInfoRequest;
import id.parkee.test.common.model.result.BaseResult;
import id.parkee.test.common.model.result.ticket.TicketInfoResult;
import id.parkee.test.common.model.summary.TicketSummary;
import id.parkee.test.common.util.AssertUtil;
import id.parkee.test.core.processor.BaseProcessor;
import id.parkee.test.core.service.TicketService;
import id.parkee.test.foundation.model.TicketDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TicketInfoProcessor implements BaseProcessor {

    @Autowired
    private TicketService ticketService;

    @Override
    public void process(BaseRequest baseRequest, BaseResult baseResult) {
        TicketInfoRequest request = (TicketInfoRequest) baseRequest;
        TicketInfoResult result = (TicketInfoResult) baseResult;

        String ticketNumber = request.getTicketNumber();
        TicketDO ticket = ticketService.findByTicketNumber(ticketNumber);
        AssertUtil.isNotNull(ticket, ParkeeErrorCode.TICKET_NOT_FOUND.getErrorMessage(),
                ParkeeErrorCode.TICKET_NOT_FOUND);

        result.setTicketInfo(convertToSummary(ticket));
    }

    private TicketSummary convertToSummary(TicketDO ticket) {
        if (ticket == null) {
            return null;
        }

        TicketSummary summary = new TicketSummary();
        summary.setTicketNumber(ticket.getTicketNumber());
        summary.setVehicleType(ticket.getVehicleType());
        summary.setAreaCode(ticket.getAreaCode());
        summary.setPlateNumber(ticket.getPlateNumber());
        summary.setPlateCode(ticket.getPlateCode());
        summary.setCheckInTime(ticket.getCheckIn());
        if (ticket.getCheckOut() != null) {
            summary.setCheckOutTime(ticket.getCheckOut());
        } else {
            summary.setCheckOutTime(new Date());
        }

        long hours = (summary.getCheckOutTime().getTime() - summary.getCheckInTime().getTime()) / (1000 * 60 * 60);
        summary.setPrice(hours * 3000);


        return summary;
    }
}
