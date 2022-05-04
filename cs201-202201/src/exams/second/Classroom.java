/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/04/29
 * 
 */
package exams.second;

public class Classroom {
    protected String building;
    protected String roomNumber;
    private int seats;

    public Classroom() {
        this.building = "";
        this.roomNumber = "";
        this.seats = 0;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setRoomNumber(String number) {
        this.roomNumber = number;
    }

    public void setSeats(int seats) {
        this.seats = seats > 0 ? seats : 0;
    }

    public String getBuilding() {
        return this.building;
    }

    public String getRoomNumber() {
        return this.roomNumber;
    }

    public int getSeats() {
        return this.seats;
    }

    @Override
    public String toString() {
        return "Building: " + this.building + " RoomNumber: " + this.roomNumber + " Seats: " + this.seats;
    }
}
