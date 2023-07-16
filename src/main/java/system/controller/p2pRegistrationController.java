package system.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import system.model.Vehicle;
import system.model.User;
import system.dao.VehicleDAO;

/**
 * Servlet implementation class p2pRegistrationController
 */
//@WebServlet("/source/user_pages/p2p_page/p2p-registerController")
@WebServlet("/source/user_pages/front_page/p2p-registerController")
public class p2pRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/source/user_pages/p2p_page/p2p-register.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		VehicleDAO vehicledao = new VehicleDAO();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userobj");
		Vehicle vehicle = new Vehicle();
		Map<String, String> formFields = new HashMap<>();
		int imgIndex = vehicledao.getNewVehicleID();
        
        try {
        	ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> multifiles = sf.parseRequest(request);
			
			for(FileItem item : multifiles) {
				if (item.isFormField()) {
                    // Handle regular form fields (text inputs)
                    String fieldName = item.getFieldName();
                    String fieldValue = item.getString();
                    formFields.put(fieldName, fieldValue);
                } else {
                    // Handle uploaded files
                	item.write(new File("D:\\software\\eclipse\\2nd-Yr-Project\\PROJECT\\src\\main\\webapp\\source\\user_pages\\carPic\\" + imgIndex + ".jpg"));
                    // ...
                }
			}
			
			System.out.println("File Uploaded");
        }catch(Exception e) {
        	e.printStackTrace();;
        }
        
        System.out.println("Testing Purpose : ");
        System.out.println(formFields.get("insuranceType"));
        
        vehicle.setV_brand(formFields.get("brand"));
        vehicle.setV_model(formFields.get("model"));
        vehicle.setV_type(formFields.get("type"));
        vehicle.setYr_manufacture(Integer.parseInt(formFields.get("yearManufactured")));
        vehicle.setGasType(formFields.get("gasType"));
        vehicle.setSeatNum(Integer.parseInt(formFields.get("numberOfSeater")));
        vehicle.setTransmission(formFields.get("transmission"));
        vehicle.setRegistration_num(formFields.get("registrationNumber"));
        vehicle.setRoadtax_exp_date(formFields.get("roadtaxExpiryDate"));
        vehicle.setEngine_num(formFields.get("engineNumber"));
        vehicle.setChasis_num(formFields.get("chasisNumber"));
        vehicle.setInsurance_type(formFields.get("insuranceType"));
        vehicle.setInsurance_name(formFields.get("insuranceName"));
        vehicle.setInsurance_exp_date(formFields.get("insuranceExpiryDate"));
        vehicle.setLocation(formFields.get("location"));
        vehicle.setRental_pr_hr(Double.parseDouble(formFields.get("rentalCharge")));
        vehicle.setImg_path(imgIndex);
        //vehicle.setV_color(formFields.get("color"));
        //vehicle.setDescription(formFields.get("description"));
        
        System.out.print(vehicle.toString());
        
        try {
        	int rowCount = vehicledao.registerCar(vehicle, user.getUserid());
        	dispatcher = request.getRequestDispatcher("/source/user_pages/dashboard_page/user-dashboard.jsp");
        	if(rowCount > 0) {
				request.setAttribute("status", "success");
			}else {
				request.setAttribute("status", "failed");
			}
			dispatcher.forward(request, response);
        }catch (Exception e) {
        	e.printStackTrace();
        }
	}

}
