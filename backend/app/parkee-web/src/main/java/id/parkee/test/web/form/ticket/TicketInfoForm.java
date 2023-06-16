package id.parkee.test.web.form.ticket;

import id.parkee.test.web.form.BaseForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketInfoForm extends BaseForm {
    private static final long serialVersionUID = -2360053702764534487L;

    private String ticketNumber;
}
