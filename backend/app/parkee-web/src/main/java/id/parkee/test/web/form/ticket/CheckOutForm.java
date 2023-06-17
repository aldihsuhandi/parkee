package id.parkee.test.web.form.ticket;

import id.parkee.test.web.form.BaseForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckOutForm extends BaseForm {
    private static final long serialVersionUID = 7043395152923173209L;

    private String ticketNumber;
}
