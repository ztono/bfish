package BEAN;

public class Room {
    private String room_id;
    private String room_type;
    private String room_state;
    private String room_price;
    private String room_location;
    private String room_no;

    public Room() {

    }

    public Room(String room_id, String room_type, String room_state, String room_price, String room_location, String  room_no) {
        this.room_id = room_id;
        this.room_type = room_type;
        this.room_state = room_state;
        this.room_price = room_price;
        this.room_location = room_location;
        this.room_no = room_no;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getRoom_state() {
        return room_state;
    }

    public void setRoom_state(String room_state) {
        this.room_state = room_state;
    }

    public String getRoom_price() {
        return room_price;
    }

    public void setRoom_price(String room_price) {
        this.room_price = room_price;
    }

    public String getRoom_location() {
        return room_location;
    }

    public void setRoom_location(String room_location) {
        this.room_location = room_location;
    }

    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }
}
