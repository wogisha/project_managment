package edu.mum.domain;

import javax.persistence.Embeddable;
import java.util.Date;

/**
 * Created by wogisha on 30/07/2017.
 */

@Embeddable
public class TimeFrame {
    private Date startDate;
    private Date endDate;

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
