package BEAN;

public class ReserveShow {
    private int reserve_no;
    private String client_id;
    private String clien_name;
    private String room_id;
    private String room_type;
    private String room_price;
    private String room_state;
    private String arr_date;
    private String lea_date;


    public ReserveShow() {
    }

    public String getRoom_state() {
        return room_state;
    }

    public void setRoom_state(String room_state) {
        this.room_state = room_state;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getRoom_price() {
        return room_price;
    }

    public void setRoom_price(String room_price) {
        this.room_price = room_price;
    }

    public int getReserve_no() {
        return reserve_no;
    }

    public void setReserve_no(int reserve_no) {
        this.reserve_no = reserve_no;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClien_name() {
        return clien_name;
    }

    public void setClien_name(String clien_name) {
        this.clien_name = clien_name;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
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
