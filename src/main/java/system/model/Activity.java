package system.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Activity {
	private User user;
	private Vehicle vehicle;
	private Reservation reservation;
	private String userStatus; //'Tenant'(user rent the car) 'Lessor'(user provide the car)
	private String activityStatus; //'toPickup' 'pickupDay' 'toDrop' 'dropDay' 'vacant'(no activities)
	
	public Activity() {
		user = new User();
		vehicle = new Vehicle();
		reservation = new Reservation();
		userStatus = "default";
	}
	
	public Activity(User u, Vehicle v, Reservation r, String status) {
		setUser(u);
		setVehicle(v);
		setReservation(r);
		setUserStatus(status);
		activityStatus();
	}
	
	private void activityStatus() {
		Date pickup_date = reservation.getPickup_date();
		Date drop_date = reservation.getDrop_date();
		Date currentDate = new Date();
		
		if (currentDate.before(pickup_date)) {
			activityStatus = "toPickup";
		}else if (currentDate.equals(pickup_date)) {
			activityStatus = "pickupDay";
		}else if ((currentDate.before(drop_date) && currentDate.after(pickup_date))) {
			activityStatus = "toDrop";
		}else if (currentDate.equals(drop_date)) {
			activityStatus = "dropDay";
		}else {activityStatus = "vacant";}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String status) {
		this.userStatus = status;
	}
	
	public String toString() {
		return
				"\n[USER]\n" + 
				user.toString() +
				"\n[VEHICLE]\n" + 
				vehicle.toString()+
				"\n[REGISTRATION]\n" +
				reservation.toString() +
				"\n[STATUS]\n" +
				"\nuser status : \n" + userStatus +
				"actv status : " + activityStatus;
	}
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
}
