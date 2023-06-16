package id.parkee.test.web.form;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class BaseForm implements Serializable {
    private static final long serialVersionUID = 6119378547580396540L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
