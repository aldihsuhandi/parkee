package id.parkee.test.common.model.result.ticket;

import id.parkee.test.common.model.result.BaseResult;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckInResult extends BaseResult {
    private static final long serialVersionUID = 920495297718839875L;

    private String ticketNumber;
}
