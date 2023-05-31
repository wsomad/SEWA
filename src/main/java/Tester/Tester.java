package Tester;
import system.model.*;
import java.text.DecimalFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Tester {
	public static void main(String[] args) {
		User user = new User();
		System.out.println(user.toString());
		getDate();
	}
	
	public static void getDate() {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = dateFormat.format(currentDate);
		System.out.println(formattedDate);
		
		//To Compare before and after
		String custDate = "29/05/2023";
        try{
            Date customDate = dateFormat.parse(custDate);
            if(customDate.before(currentDate)) {
            	System.out.println(custDate + " is before " + formattedDate);
            }else {
            	System.out.println(custDate + " is after " + formattedDate);
            }
        }catch (Exception e){
            System.out.println("Error parsing the custom date: " + e.getMessage());
        }
	}
}
