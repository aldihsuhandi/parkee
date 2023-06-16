package id.parkee.test.common.model.request.ticket;

import id.parkee.test.common.model.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckInRequest extends BaseRequest {
    private static final long serialVersionUID = 5387903849781680214L;

    private String vehicleType;
    private String areaCode;
    private String plateNumber;
    private String plateCode;
}
