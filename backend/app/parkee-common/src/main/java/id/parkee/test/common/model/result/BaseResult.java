package id.parkee.test.common.model.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class BaseResult implements Serializable {
    private static final long serialVersionUID = -4020673650363294164L;

    private boolean success;
    private String resultCode;
    private String resultMessage;
}
