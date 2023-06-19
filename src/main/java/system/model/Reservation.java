package system.model;

public class Reservation {
	private int reservation_userid;
	private int reservation_vehcileid;
	private String pickup_date;
	private String drop_date;
	private int passengers_num;
	private String special_req;
	private double rent_to_pay;
	
	public int getReservation_userid() {
		return reservation_userid;
	}
	public void setReservation_userid(int reservation_userid) {
		this.reservation_userid = reservation_userid;
	}
	public int getReservation_vehcileid() {
		return reservation_vehcileid;
	}
	public void setReservation_vehcileid(int reservation_vehcileid) {
		this.reservation_vehcileid = reservation_vehcileid;
	}
	public String getPickup_date() {
		return pickup_date;
	}
	public void setPickup_date(String pickup_date) {
		this.pickup_date = pickup_date;
	}
	public String getDrop_date() {
		return drop_date;
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
}
