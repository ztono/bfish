package BEAN;

public class Reserve {
        private int reserve_no;
        private int client_no;
        private String room_no;
        private String arr_date;
        private String lea_date;

    public Reserve()
    {

    }
    public Reserve( int client_no, String room_no, String arr_date, String lea_date) {

        this.client_no = client_no;
        this.room_no = room_no;
        this.arr_date = arr_date;
        this.lea_date = lea_date;
    }

    public int getReserve_no() {
        return reserve_no;
    }

    public void setReserve_no(int reserve_no) {
        this.reserve_no = reserve_no;
    }

    public int getClient_no() {
        return client_no;
    }

    public void setClient_no(int client_no) {
        this.client_no = client_no;
    }

    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public String getArr_date() {
        return arr_date;
    }

    public void setArr_date(String arr_date) {
        this.arr_date = arr_date;
    }

    public String getLea_date() {
        return lea_date;
    }

    public void setLea_date(String lea_date) {
        this.lea_date = lea_date;
    }
}
