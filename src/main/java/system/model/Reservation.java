package system.model;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Reservation {
	private int reservation_userid;
	private int reservation_vehicleid;
	private String pickup_location;
	private String drop_location;
	private String pickup_date;
	private String drop_date;
	private int passengers_num;
	private String special_req;
	private double rent_to_pay;
	private int day_count;
	private Timestamp insertionTimestamp;
	private boolean eye;
	
	//Normal Constructor
	public Reservation(int userId, int vehicleId,String pickupLoc, String dropLoc, String pickupDate, String dropDate, int passengersNum, String specialReq, double rentToPay, Timestamp t, boolean eye) {
        this.reservation_userid = userId;
        this.reservation_vehicleid = vehicleId;
        pickup_location = pickupLoc;
        drop_location = dropLoc;
        this.pickup_date = pickupDate;
        this.drop_date = dropDate;
        this.passengers_num = passengersNum;
        this.special_req = specialReq;
        this.rent_to_pay = rentToPay;
        insertionTimestamp = t;
        this.setEye(eye);
        countDays();
    }
	
	//Days Counter
	private void countDays() {
		long timeDifference = getDrop_date().getTime() - getPickup_date().getTime();
		day_count =  (int) TimeUnit.MILLISECONDS.toDays(timeDifference);

	}
	
	//Default Constructor
	public  Reservation() {
        reservation_userid = 0;
        reservation_vehicleid = 0;
        pickup_date = "default";
        drop_date = "default";
        passengers_num = 0;
        special_req = "default";
        rent_to_pay = 0.0;
    }
	
	public int getReservation_userid() {
		return reservation_userid;
	}
	public void setReservation_userid(int reservation_userid) {
		this.reservation_userid = reservation_userid;
	}
	public int getReservation_vehicleid() {
		return reservation_vehicleid;
	}
	public void setReservation_vehicleid(int reservation_vehcileid) {
		this.reservation_vehicleid = reservation_vehcileid;
	}
	public String getPickup_location() {
		return pickup_location;
	}

	public void setPickup_location(String pickup_location) {
		this.pickup_location = pickup_location;
	}

	public String getDrop_location() {
		return drop_location;
	}

	public void setDrop_location(String drop_location) {
		this.drop_location = drop_location;
	}
	
	public String getPickup_DateString() {
		return pickup_date;
	}
	
	public Date getPickup_date() {
		Date date = null;
		try {
			date = dateFormat.parse(pickup_date);
		}catch(Exception e) {
			System.out.println("Error parsing the custom date: " + e.getMessage());
		}
		return date;
	}
	public void setPickup_date(String pickup_date) {
		this.pickup_date = pickup_date;
	}
	
	public String getDrop_DateString() {
		return drop_date;
	}
	
	public Date getDrop_date() {
		Date date = null;
		try {
			date = dateFormat.parse(drop_date);
		}catch(Exception e) {
			System.out.println("Error parsing the custom date: " + e.getMessage());
		}
		return date;
	}
	public void setDrop_date(String drop_date) {
		this.drop_date = drop_date;
	}
	public int getPassengers_num() {
		return passengers_num;
	}
	public void setPassengers_num(int passengers_num) {
		this.passengers_num = passengers_num;
	}
	public String getSpecial_req() {
		return special_req;
	}
	public void setSpecial_req(String special_req) {
		this.special_req = special_req;
	}
	public double getRent_to_pay() {
		return rent_to_pay;
	}
	public void setRent_to_pay(double rent_to_pay) {
		this.rent_to_pay = rent_to_pay;
	}
	
	public int getDay_count() {
		return day_count;
	}

	public void setDay_count(int day_count) {
		this.day_count = day_count;
	}
	
	public Timestamp getInsertionTimestamp() {
		return insertionTimestamp;
	}

	public void setInsertionTimestamp(Timestamp insertionTimestamp) {
		this.insertionTimestamp = insertionTimestamp;
	}

	public boolean isEye() {
		return eye;
	}

	public void setEye(boolean eye) {
		this.eye = eye;
	}

	public String toString() {
        return "Reservation{" +
                "\nreservation_userid=" + reservation_userid +
                ", \nreservation_vehicleid=" + reservation_vehicleid +
                ", \npickup_location='" + pickup_location + '\'' +
                ", \ndrop_location='" + drop_location + '\'' +
                ", \npickup_date='" + pickup_date + '\'' +
                ", \ndrop_date='" + drop_date + '\'' +
                ", \npassengers_num=" + passengers_num +
                ", \nspecial_req='" + special_req + '\'' +
                ", \nrent_to_pay=" + rent_to_pay +
                ", \ndays count=" + day_count +
                '}';
    }
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
}
