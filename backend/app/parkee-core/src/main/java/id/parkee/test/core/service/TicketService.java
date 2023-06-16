package id.parkee.test.core.service;

import id.parkee.test.foundation.model.TicketDO;

public interface TicketService {
    TicketDO findByPlateCombination(String areaCode, String plateNumber, String plateCode);

    TicketDO findByTicketNumber(String ticketNumber);

    String create(String areaCode, String plateNumber, String plateCode, String vehicleType);
}
