package system.model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Vehicle {
	private int vehicleid;//
	private boolean availability;//
	private String registration_num;//
	private String chasis_num;//
	private String engine_num;//
	private String v_brand;//
	private String v_model;//
	private String v_type;//
	private String v_color;//
	private int yr_manufacture;//
	private String roadtax_exp_date;//
	private String insurance_name;//
	private String insurance_exp_date;//
	private String insurance_type;//
	private String description;//
	private double rental_pr_hr;//
	private int img_path;//
	private String gasType;
	private int seatNum;
	private String transmission;
	private String location;
	
	public Vehicle() {
		vehicleid = 0;
		availability = false;
		registration_num = "default";
		chasis_num = "default";
		engine_num = "default";
		v_brand = "default";
		v_model = "default";
		v_type = "default";
		v_color = "default";
		yr_manufacture = 0;
		roadtax_exp_date = "dd/MM/yyyy";
		insurance_name = "default";
		insurance_exp_date = "dd/MM/yyyy";
		insurance_type = "default";
		description = "default";
		rental_pr_hr = 0.0;
		img_path = 0;
		setGasType("default");
		setSeatNum(0);
		setTransmission("default");
		setLocation("default");
	}
	
	public Vehicle(int id, boolean avail, String reg_num, String chas_num, String eng_num, String brand, String model, String type, String color, int yr_manu,
			String roadtax_exp_date, String insur_name, String insurance_exp_date, String insur_type, String desc, double rental_pr_hr, int img_path, String gas, int seat, String transmission, String location) {
		setVehicleid(id);
		setAvailability(avail);
		setRegistration_num(reg_num);
		setChasis_num(chas_num);
		setEngine_num(eng_num);
		setV_brand(brand);
		setV_model(model);
		setV_type(type);
		setV_color(color);
		setYr_manufacture(yr_manu);
		this.setRoadtax_exp_date(roadtax_exp_date);
		setInsurance_name(insur_name);
		this.setInsurance_exp_date(insurance_exp_date);
		setInsurance_type(insur_type);
		setDescription(desc);
		this.setRental_pr_hr(rental_pr_hr);
		this.setImg_path(img_path);
		setGasType(gas);
		setSeatNum(seat);
		setTransmission(transmission);
		setLocation(location);
	}

	public int getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}

	public boolean getAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public String getRegistration_num() {
		return registration_num;
	}

	public void setRegistration_num(String registration_num) {
		this.registration_num = registration_num;
	}

	public String getChasis_num() {
		return chasis_num;
	}

	public void setChasis_num(String chasis_num) {
		this.chasis_num = chasis_num;
	}

	public String getEngine_num() {
		return engine_num;
	}

	public void setEngine_num(String engine_num) {
		this.engine_num = engine_num;
	}

	public String getV_brand() {
		return v_brand;
	}

	public void setV_brand(String v_brand) {
		this.v_brand = v_brand;
	}

	public String getV_model() {
		return v_model;
	}

	public void setV_model(String v_model) {
		this.v_model = v_model;
	}

	public String getV_type() {
		return v_type;
	}

	public void setV_type(String v_type) {
		this.v_type = v_type;
	}

	public String getV_color() {
		return v_color;
	}

	public void setV_color(String v_color) {
		this.v_color = v_color;
	}

	public int getYr_manufacture() {
		return yr_manufacture;
	}

	public void setYr_manufacture(int yr_manufacture) {
		this.yr_manufacture = yr_manufacture;
	}
	//---
	public Date getRoadtax_exp_date() {
		Date date = null;
		try {
			date = dateFormat.parse(roadtax_exp_date);
		}catch(Exception e) {
			System.out.println("Error parsing the custom date: " + e.getMessage());
		}
		return date;
	}
	
	public String getStringRoadtax_exp_date() {
		return roadtax_exp_date;
	}

	public void setRoadtax_exp_date(String roadtax_exp_date) {
		this.roadtax_exp_date = roadtax_exp_date;
	}

	public String getInsurance_name() {
		return insurance_name;
	}

	public void setInsurance_name(String insurance_name) {
		this.insurance_name = insurance_name;
	}

	public Date getInsurance_exp_date() {
		Date date = null;
		try {
			date = dateFormat.parse(insurance_exp_date);
		}catch(Exception e) {
			System.out.println("Error parsing the custom date: " + e.getMessage());
		}
		return date;
	}
	
	public String getStringInsurance_exp_date() {
		return insurance_exp_date;
	}
	
	public void setInsurance_exp_date(String insurance_exp_date) {
		this.insurance_exp_date = insurance_exp_date;
	}

	public String getInsurance_type() {
		return insurance_type;
	}

	public void setInsurance_type(String insurance_type) {
		this.insurance_type = insurance_type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRental_pr_hr() {
		return rental_pr_hr;
	}

	public void setRental_pr_hr(double rental_pr_hr) {
		this.rental_pr_hr = rental_pr_hr;
	}

	public int getImg_path() {
		return img_path;
	}

	public void setImg_path(int i) {
		this.img_path = i;
	}
	
	public String getGasType() {
		return gasType;
	}

	public void setGasType(String gasType) {
		this.gasType = gasType;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String toString() {
	    return "Vehicle{" +
	            "vehicleid=" + vehicleid +
	            ", availability=" + availability +
	            ", registration_num='" + registration_num + '\'' +
	            ", chasis_num='" + chasis_num + '\'' +
	            ", engine_num='" + engine_num + '\'' +
	            ", v_brand='" + v_brand + '\'' +
	            ", v_model='" + v_model + '\'' +
	            ", v_type='" + v_type + '\'' +
	            ", v_color='" + v_color + '\'' +
	            ", yr_manufacture=" + yr_manufacture +
	            ", roadtax_exp_date='" + roadtax_exp_date + '\'' +
	            ", insurance_name='" + insurance_name + '\'' +
	            ", insurance_exp_date='" + insurance_exp_date + '\'' +
	            ", insurance_type='" + insurance_type + '\'' +
	            ", description='" + description + '\'' +
	            ", rental_pr_hr=" + rental_pr_hr +
	            ", img_path='" + img_path + '\'' +
	            '}';
	}

	//Random Instantiation
	//Date purpose
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
}
