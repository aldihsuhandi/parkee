package id.parkee.test.core.service.impl;

import id.parkee.test.common.model.constant.LoggerConstant;
import id.parkee.test.common.model.enums.TicketStatusEnum;
import id.parkee.test.common.util.LoggerUtil;
import id.parkee.test.core.service.TicketService;
import id.parkee.test.foundation.model.TicketDO;
import id.parkee.test.foundation.repository.TicketRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerConstant.SERVICE_LOGGER);

    @Override
    public TicketDO findByPlateCombination(String areaCode, String plateNumber, String plateCode) {
        LoggerUtil.info(LOGGER, String.format("ticketService#findByPlateCombination invoke request[areaCode=%s, plateNumber=%s, plateCode=%s]",
                areaCode, plateNumber, plateCode));
        TicketDO ticket = ticketRepository.findByPlateCombination(areaCode, plateNumber, plateCode).orElse(null);
        LoggerUtil.info(LOGGER, String.format("ticketService#findByPlateCombination invoke result[ticket=%s]", ticket));
        return ticket;
    }

    @Override
    public String create(String areaCode, String plateNumber, String plateCode) {
        LoggerUtil.info(LOGGER, String.format("ticketService#create invoke request[areaCode=%s, plateNumber=%s, plateCode=%s]",
                areaCode, plateNumber, plateCode));

        String ticketNumber = RandomStringUtils.random(10, false, true);

        TicketDO ticket = new TicketDO();
        ticket.setTicketNumber(ticketNumber);
        ticket.setAreaCode(areaCode);
        ticket.setPlateCode(plateCode);
        ticket.setPlateNumber(plateNumber);
        ticket.setStatus(TicketStatusEnum.CHECKED_IN.getStatus());
        ticket.setCheckIn(new Date());

        ticketRepository.save(ticket);

        LoggerUtil.info(LOGGER, String.format("ticketService#create invoke result[ticketNumber=%s]", ticketNumber));
        return ticketNumber;
    }
}
