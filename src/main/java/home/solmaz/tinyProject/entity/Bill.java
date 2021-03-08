package home.solmaz.tinyProject.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Bill {
    private final String billId;
    private final String paymentId;
    private final String Amount;

    public Bill(String billId, String paymentId, String amount) {
        this.billId = billId;
        this.paymentId = paymentId;
        Amount = amount;
    }

    public  char getCompanyType(){
        int strLength=this.getBillId().length();
        return this.billId.charAt(strLength-2);
    }

    public  String getCompanyCode(){
        int strLength=this.getBillId().length();
        return  this.billId.substring(strLength-5,strLength-2);
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getAmount() {
        return Amount;
    }

    public String getBillId() {
        return billId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Bill)) return false;

        Bill bill = (Bill) o;

        return new EqualsBuilder()
                .append(billId, bill.billId)
                .append(paymentId, bill.paymentId)
                .append(Amount, bill.Amount)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(billId)
                .append(paymentId)
                .append(Amount)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId='" + billId + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", Amount='" + Amount + '\'' +
                '}';
    }
}
