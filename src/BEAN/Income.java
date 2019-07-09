package BEAN;

public class Income {

    private String room_type;

    private String year;
    private String mounth;
    private String cost;
    /**
     * @return the room_type
     */
    public String getRoom_type() {
        return room_type;
    }
    /**
     * @param room_type the room_type to set
     */
    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }


    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }
    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }
    /**
     * @return the mounth
     */
    public String getMounth() {
        return mounth;
    }
    /**
     * @param mounth the mounth to set
     */
    public void setMounth(String mounth) {
        this.mounth = mounth;
    }
    /**
     * @return the cost
     */
    public String getCost() {
        return cost;
    }
    /**
     * @param cost the cost to set
     */
    public void setCost(String cost) {
        this.cost = cost;
    }


    public boolean equals(Object obj){
        if (obj == null) return false ;
        else{
            if (obj instanceof Income){
                Income c = (Income) obj;
                if(c.getRoom_type()== this.room_type ){
                    return true ;
                }
            }
        }
        return false ;
    }








}
