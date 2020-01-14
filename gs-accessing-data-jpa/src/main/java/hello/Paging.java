package hello;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Paging implements Serializable {
    public static final int DEFAULT_OFFSET = 0;
    public static final int DEFAULT_LIMIT = Integer.MAX_VALUE;

    private int offset = DEFAULT_OFFSET;
    private int limit = DEFAULT_LIMIT;

    public Paging(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public Paging() {
        /*
           We use this constructor for implicitly
           in ShippingReceivingController.java and in ShippingReceivingControllerTest.java
        */
    }

    public static Paging defaultPaging() {
        return new Paging(DEFAULT_OFFSET, DEFAULT_LIMIT);
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Paging rhs = (Paging) obj;
        return new EqualsBuilder()
                .append(this.offset, rhs.offset)
                .append(this.limit, rhs.limit)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(offset)
                .append(limit)
                .toHashCode();
    }
}
