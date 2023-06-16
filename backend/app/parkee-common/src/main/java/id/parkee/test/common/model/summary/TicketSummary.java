package id.parkee.test.common.model.summary;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class TicketSummary implements Serializable {
    private static final long serialVersionUID = -3697377096640794386L;

    private String ticketNumber;
    private String vehicleType;
    private String areaCode;
    private String plateNumber;
    private String plateCode;
    private Date checkInTime;
    private Date checkOutTime;
    private Long price;
}
