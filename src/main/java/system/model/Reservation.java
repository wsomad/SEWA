package system.model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Reservation {
	private int reservation_userid;
	private int reservation_vehicleid;
	private String pickup_date;
	private String drop_date;
	private int passengers_num;
	private String special_req;
	private double rent_to_pay;
	
	//Normal Constructor
	public Reservation(int userId, int vehicleId, String pickupDate, String dropDate, int passengersNum, String specialReq, double rentToPay) {
        this.reservation_userid = userId;
        this.reservation_vehicleid = vehicleId;
        this.pickup_date = pickupDate;
        this.drop_date = dropDate;
        this.passengers_num = passengersNum;
        this.special_req = specialReq;
        this.rent_to_pay = rentToPay;
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
	public void setReservation_vehcileid(int reservation_vehcileid) {
		this.reservation_vehicleid = reservation_vehcileid;
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
	
	public String toString() {
        return "Reservation{" +
                "\nreservation_userid=" + reservation_userid +
                ", \nreservation_vehicleid=" + reservation_vehicleid +
                ", \npickup_date='" + pickup_date + '\'' +
                ", \ndrop_date='" + drop_date + '\'' +
                ", \npassengers_num=" + passengers_num +
                ", \nspecial_req='" + special_req + '\'' +
                ", \nrent_to_pay=" + rent_to_pay +
                '}';
    }
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
}
