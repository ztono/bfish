package BEAN;

public class Change {
    private String oldroomid;
    private String newroomid;
    private String client_no;

    public Change() {
    }

    public Change(String oldroomid, String newroomid, String client_no) {
        this.oldroomid = oldroomid;
        this.newroomid = newroomid;
        this.client_no = client_no;
    }

    public String getOldroomid() {
        return oldroomid;
    }

    public void setOldroomid(String oldroomid) {
        this.oldroomid = oldroomid;
    }

    public String getNewroomid() {
        return newroomid;
    }

    public void setNewroomid(String newroomid) {
        this.newroomid = newroomid;
    }

    public String getClient_no() {
        return client_no;
    }

    public void setClient_no(String client_no) {
        this.client_no = client_no;
    }
}
