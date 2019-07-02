package BEAN;

public class Checkin {
    private int checkin_no;
    private String arrivedate;
    private String leavedate;
    private String client_no;
    private String room_no;
    private String isdamaged;
    private String exp_score;
    private String ser_score;

    public Checkin() {
    }

    public Checkin(String client_no, String room_no, String isdamaged, String exp_score, String ser_score) {
        this.client_no = client_no;
        this.room_no = room_no;
        this.isdamaged = isdamaged;
        this.exp_score = exp_score;
        this.ser_score = ser_score;
    }

    public int getCheckin_no() {
        return checkin_no;
    }

    public void setCheckin_no(int checkin_no) {
        this.checkin_no = checkin_no;
    }

    public String getArrivedate() {
        return arrivedate;
    }

    public void setArrivedate(String arrivedate) {
        this.arrivedate = arrivedate;
    }

    public String getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(String leavedate) {
        this.leavedate = leavedate;
    }

    public String getClient_no() {
        return client_no;
    }

    public void setClient_no(String client_no) {
        this.client_no = client_no;
    }

    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public String getIsdamaged() {
        return isdamaged;
    }

    public void setIsdamaged(String isdamaged) {
        this.isdamaged = isdamaged;
    }

    public String getExp_score() {
        return exp_score;
    }

    public void setExp_score(String exp_score) {
        this.exp_score = exp_score;
    }

    public String getSer_score() {
        return ser_score;
    }

    public void setSer_score(String ser_score) {
        this.ser_score = ser_score;
    }

}
