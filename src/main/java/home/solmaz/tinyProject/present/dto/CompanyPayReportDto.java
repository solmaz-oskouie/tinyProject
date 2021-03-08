package home.solmaz.tinyProject.present.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class CompanyPayReportDto {
    private final String companyName;
    private final long count;
    private  final long totlaAmount;

    public CompanyPayReportDto(String companyName, long count, long totlaAmount) {
        this.companyName = companyName;
        this.count = count;
        this.totlaAmount = totlaAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof CompanyPayReportDto)) return false;

        CompanyPayReportDto that = (CompanyPayReportDto) o;

        return new EqualsBuilder()
                .append(count, that.count)
                .append(totlaAmount, that.totlaAmount)
                .append(companyName, that.companyName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(companyName)
                .append(count)
                .append(totlaAmount)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "CompanyPayReportDto{" +
                "companyName='" + companyName + '\'' +
                ", count=" + count +
                ", totlaAmount=" + totlaAmount +
                '}';
    }
}
