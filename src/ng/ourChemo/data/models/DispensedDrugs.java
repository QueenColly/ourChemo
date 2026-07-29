package ng.ourChemo.data.models;

import java.time.LocalDateTime;
import java.util.List;

public class DispensedDrugs {
    private User dispensedBy;
    private List<DispensedDrug> dispensedDrugs ;
    private LocalDateTime dispensedDateTime;
    private int dispensedDrugsId;

    public  DispensedDrugs(){
        this.dispensedBy = dispensedBy;
        this.dispensedDateTime = dispensedDateTime;
        this.dispensedDrugsId = dispensedDrugsId;
    }

    public User getDispensedBy() {
        return dispensedBy;
    }

    public void setDispensedBy(User dispensedBy) {
        this.dispensedBy = dispensedBy;
    }

    public LocalDateTime getDispensedDateTime() {
        return dispensedDateTime;
    }

    public void setDispensedDateTime(LocalDateTime dispensedDateTime) {
        this.dispensedDateTime = dispensedDateTime;
    }

    public int getDispensedDrugsId() {
        return dispensedDrugsId;
    }

    public void setDispensedDrugsId(int dispensedDrugsId) {
        this.dispensedDrugsId = dispensedDrugsId;
    }

    public List<DispensedDrug> getDispensedDrugs() {
        return dispensedDrugs;
    }

    public void setDispensedDrugs(List<DispensedDrug> dispensedDrugs) {
        this.dispensedDrugs = dispensedDrugs;
    }
}