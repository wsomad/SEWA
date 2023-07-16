<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
	<%@include file="cars.css"%>
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="booking_container">
                    <div class="booking_details">
                        <div class="car_image">
                        	<!-- -------------------------- -->
                            <!--<img src="https://drive.google.com/uc?export=view&id=1cs19Dr4j-sI_380xEyuakdWcKdUj5cY8" alt="">-->
                            <img src="../cars_page/2.jpg">
                        </div>
                    </div>
                    <div class="car_name">
                        <p class="book_title">brand model</p>
                    </div>
                    <div class="features_container">
                        <p>Features</p>
                        <div class="features">
                            <div class="features_box">
                                <div class="features_info">
                                    <i class="fa fa-car"></i>
                                </div>
                                <div class="features_type">
                                    <p>type</p>
                                </div>
                            </div>
                            <div class="features_box">
                                <div class="features_info">
                                    <i class="fa fa-solid fa-gas-pump"></i>
                                </div>
                                <div class="features_type">
                                    <p>Petrol</p>
                                </div>
                            </div>
                            <div class="features_box">
                                <div class="features_info">
                                    <i class="fa fa-users"></i>
                                </div>
                                <div class="features_type">
                                    <p>5 Seaters</p>
                                </div>
                            </div>
                            <div class="features_box">
                                <div class="features_info">
                                    <i class="fa fa-gears"></i>
                                </div>
                                <div class="features_type">
                                    <p>Automatic</p>
                                </div>
                            </div>                    
                        </div>
                    </div>
                    <div class="car_rate">
                        <p class="book_rate">RM 00<span>per hour</span> </p>
                    </div>
                    <form method="post" action="BookingController">
                    	<input type="hidden" name="vehicleId" value="vehicleid">
                    	<button class="booking_button">Book Now</button>
                   	</form>
                </div>
</body>
</html>