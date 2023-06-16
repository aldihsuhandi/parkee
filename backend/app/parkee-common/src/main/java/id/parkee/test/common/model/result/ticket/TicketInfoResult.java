package id.parkee.test.common.model.result.ticket;

import id.parkee.test.common.model.result.BaseResult;
import id.parkee.test.common.model.summary.TicketSummary;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketInfoResult extends BaseResult {
    private static final long serialVersionUID = -3852609591236527292L;

    private TicketSummary ticketInfo;
}
