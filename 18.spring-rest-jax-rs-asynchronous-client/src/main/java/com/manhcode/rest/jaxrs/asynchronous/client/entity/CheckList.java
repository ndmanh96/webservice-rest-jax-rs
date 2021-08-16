package com.manhcode.rest.jaxrs.asynchronous.client.entity;

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
