package home.solmaz.tinyProject.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Company {
    private final char type;
    private final boolean enable;
    private  final String code;
    private final String account;
    private final String name;

    public Company(char type, boolean enable, String code, String account, String name) {
        this.type = type;
        this.enable = enable;
        this.code = code;
        this.account = account;
        this.name = name;
    }

    public char getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public boolean isEnable() {
        return enable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Company)) return false;

        Company company = (Company) o;

        return new EqualsBuilder()
                .append(enable, company.enable)
                .append(type, company.type)
                .append(code, company.code)
                .append(account, company.account)
                .append(name, company.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(type)
                .append(enable)
                .append(code)
                .append(account)
                .append(name)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Company{" +
                "type='" + type + '\'' +
                ", enable=" + enable +
                ", code='" + code + '\'' +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
