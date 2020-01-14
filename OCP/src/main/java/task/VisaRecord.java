package task;

import java.time.ZonedDateTime;

public class VisaRecord extends Record {

    private String country;
    private ZonedDateTime from;
    private ZonedDateTime to;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ZonedDateTime getFrom() {
        return from;
    }

    public void setFrom(ZonedDateTime from) {
        this.from = from;
    }

    public ZonedDateTime getTo() {
        return to;
    }

    public void setTo(ZonedDateTime to) {
        this.to = to;
    }
}
