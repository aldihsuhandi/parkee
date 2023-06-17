package id.parkee.test.core.processor.ticket;

import id.parkee.test.common.model.enums.ParkeeErrorCode;
import id.parkee.test.common.model.enums.TicketStatusEnum;
import id.parkee.test.common.model.request.BaseRequest;
import id.parkee.test.common.model.request.ticket.CheckOutRequest;
import id.parkee.test.common.model.result.BaseResult;
import id.parkee.test.common.util.AssertUtil;
import id.parkee.test.core.processor.BaseProcessor;
import id.parkee.test.core.service.TicketService;
import id.parkee.test.foundation.model.TicketDO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CheckOutProcessor implements BaseProcessor {

    @Autowired
    private TicketService ticketService;

    @Override
    public void process(BaseRequest baseRequest, BaseResult baseResult) {
        CheckOutRequest request = (CheckOutRequest) baseRequest;

        TicketDO ticket = ticketService.findByTicketNumber(request.getTicketNumber());
        AssertUtil.isNotNull(ticket, ParkeeErrorCode.TICKET_NOT_FOUND.getErrorMessage(), ParkeeErrorCode.TICKET_NOT_FOUND);
        AssertUtil.isExpected(StringUtils.equals(TicketStatusEnum.CHECKED_IN.getStatus(), ticket.getStatus()),
                ParkeeErrorCode.TICKET_NOT_FOUND.getErrorMessage(), ParkeeErrorCode.TICKET_NOT_FOUND);

        ticket.setStatus(TicketStatusEnum.CHECKED_OUT.getStatus());
        ticket.setCheckOut(new Date());

        ticketService.update(ticket);
    }
}
