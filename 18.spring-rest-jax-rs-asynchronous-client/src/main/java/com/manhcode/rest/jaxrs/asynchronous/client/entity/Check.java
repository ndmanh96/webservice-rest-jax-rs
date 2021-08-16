package com.manhcode.rest.jaxrs.asynchronous.client.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Check {
    private String checkNumber;
    private String accountNumber;
    private Double amount;

    public Check() {}

    public Check(String checkNumber, String accountNumber, Double amount) {
        this.checkNumber = checkNumber;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Check{" +
                "checkNumber='" + checkNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", amount=" + amount +
                '}';
    }
}
