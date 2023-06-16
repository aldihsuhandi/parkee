package id.parkee.test.core.processor.ticket;

import id.parkee.test.common.model.enums.ParkeeErrorCode;
import id.parkee.test.common.model.enums.TicketStatusEnum;
import id.parkee.test.common.model.request.BaseRequest;
import id.parkee.test.common.model.request.ticket.CheckInRequest;
import id.parkee.test.common.model.result.BaseResult;
import id.parkee.test.common.model.result.ticket.CheckInResult;
import id.parkee.test.common.util.AssertUtil;
import id.parkee.test.core.processor.BaseProcessor;
import id.parkee.test.core.service.TicketService;
import id.parkee.test.foundation.model.TicketDO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckInProcessor implements BaseProcessor {

    @Autowired
    private TicketService ticketService;

    @Override
    public void process(BaseRequest baseRequest, BaseResult baseResult) {
        CheckInRequest request = (CheckInRequest) baseRequest;
        CheckInResult result = (CheckInResult) baseResult;

        checkVehicleExist(request);

        String ticketNumber = ticketService.create(request.getAreaCode(),
                request.getPlateNumber(), request.getPlateCode());
        result.setTicketNumber(ticketNumber);
    }

    private void checkVehicleExist(CheckInRequest request) {
        TicketDO ticketDO = ticketService.findByPlateCombination(request.getAreaCode(), request.getPlateNumber(), request.getPlateCode());
        boolean check = ticketDO == null || !StringUtils.equals(TicketStatusEnum.CHECKED_IN.getStatus(), ticketDO.getStatus());
        AssertUtil.isExpected(check, ParkeeErrorCode.SIMILAR_PLATE_FOUND.getErrorMessage(), ParkeeErrorCode.SIMILAR_PLATE_FOUND);
    }
}
