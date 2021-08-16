package com.manhcode.rest.jaxrs.asynchronous.status;

import com.manhcode.rest.jaxrs.asynchronous.entity.Check;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class CheckList {
    private List<Check> checks;

    public List<Check> getChecks() {
        return checks;
    }

    public void setChecks(List<Check> checks) {
        this.checks = checks;
    }
}
