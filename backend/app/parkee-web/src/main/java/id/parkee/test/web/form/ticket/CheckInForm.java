package id.parkee.test.web.form.ticket;

import id.parkee.test.web.form.BaseForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckInForm extends BaseForm {
    private static final long serialVersionUID = 7891075576808799905L;

    private String vehicleType;
    private String areaCode;
    private String plateNumber;
    private String plateCode;
}
