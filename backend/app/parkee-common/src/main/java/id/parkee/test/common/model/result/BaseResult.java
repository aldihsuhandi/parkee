package id.parkee.test.common.model.result;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

@Getter
@Setter
public class BaseResult implements Serializable {
    private static final long serialVersionUID = -4020673650363294164L;

    private boolean success = true;
    private String resultCode;
    private String resultMessage;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
