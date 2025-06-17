package lk.ijse.gdse.dto;

public class ComplainDto {
    private String cid, uname, subject, description, date ,status;

    public ComplainDto(String cid, String uname, String subject, String description, String date, String status) {
        this.cid = cid;
        this.uname = uname;
        this.subject = subject;
        this.description = description;
        this.date = date;
        this.status = status;
    }

    public ComplainDto() {

    }

    public String getCid() {
        return cid;
    }
    public String getUname() {
        return uname;
    }
    public String getSubject() {
        return subject;
    }
    public String getDescription() {
        return description;
    }
    public String getDate() {
        return date;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
