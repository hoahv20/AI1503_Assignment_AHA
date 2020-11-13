public class BusBooking {
    String bCode;
     String bus_name;
    int seat;
     int booked;
     int depart_time;
     int arrival_time;
    BusBooking(){}
    
    BusBooking(String bCode,String bus_name,int seat,int booked,int depart_time, int arrival_time){
        this.bCode=bCode;
        this.bus_name=bus_name;
        this.seat=seat;
        this.booked=booked;
        this.depart_time=depart_time;
        this.arrival_time=arrival_time;

    }
    
    @Override
    public String toString(){
        return bCode +"|" +bus_name+ "|"+seat+"|"+booked+"|"+depart_time+"|"+arrival_time;
    }

    public String getbCode() {
        return bCode;
    }

    public void setbCode(String bCode) {
        this.bCode = bCode;
    }

    public String getBus_name() {
        return bus_name;
    }

    public void setBus_name(String bus_name) {
        this.bus_name = bus_name;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public int getDepart_time() {
        return depart_time;
    }

    public void setDepart_time(int depart_time) {
        this.depart_time = depart_time;
    }

    public int getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(int arrival_time) {
        this.arrival_time = arrival_time;
    }


    
}
