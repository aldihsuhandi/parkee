package id.parkee.test.common.model.request;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

@Getter
@Setter
public class BaseRequest implements Serializable {
    private static final long serialVersionUID = 2642963738074300061L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
