package home.solmaz.tinyProject.present.dto;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class BillDto {
    private final String billId;
    private final String paymentId;
    private final String Amount;
    private final String msg;
    private final String companyName;

    public BillDto(String billId, String paymentId, String amount, String msg,String companyName) {
        this.billId = billId;
        this.paymentId = paymentId;
        Amount = amount;
        this.msg = msg;
        this.companyName=companyName;
    }

    public String getBillId() {
        return billId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getAmount() {
        return Amount;
    }

    public String getMsg() {
        return msg;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof BillDto)) return false;

        BillDto billDto = (BillDto) o;

        return new EqualsBuilder()
                .append(billId, billDto.billId)
                .append(paymentId, billDto.paymentId)
                .append(Amount, billDto.Amount)
                .append(msg, billDto.msg)
                .append(companyName, billDto.companyName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(billId)
                .append(paymentId)
                .append(Amount)
                .append(msg)
                .append(companyName)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "BillDto{" +
                "billId='" + billId + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", Amount='" + Amount + '\'' +
                ", msg='" + msg + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
