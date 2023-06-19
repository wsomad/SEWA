<%@page import = "system.model.*" %>
<%
Vehicle vehicle = (Vehicle) request.getAttribute("vehicleInForm");
System.out.println("booking-jsp : " + vehicle.getV_brand());
%>
<!DOCTYPE html>
<html lang="en">
<style>
	<%@include file="booking.css"%>
</style>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="booking.css">
    <link rel="icon" type="images/png" href="https://drive.google.com/uc?export=view&id=1WnCOPug2C25vqv-_nxG6QvVp2VSMVnp1">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <title>SEWA | Car Rental Malaysia</title>
</head>
<body>
    <header class="header">
        <nav class="nav">
            <img src="https://drive.google.com/uc?export=view&id=1hnKz5R1P7uMvl4c2qAnSFUHrdH4Sy41B" href="admin-front.html" class="nav_logo" alt="">
            <div class="right">
                <i class='bx bx-wallet-alt wallet_show'></i>
                <button class="button" id="form-open">Back</button>
            </div>
        </nav>
    </header>
    <section class="test1">
        <div class="wallet_container" id="walletMenu">
            <i class="fa fa-times form_close"></i>
            <div class="topup">
                <div class="wallet_title">
                    <h2>Wallet Topup <span>(min. RM10)</span></h2>
                </div>
                <div class="input_form">
                    <input type="email" placeholder="Enter Amount" required>
                    <i class="fa fa-plus topup_wallet"></i>
                </div>
                <div class="current_balance">
                    <p>Current Balance | RM 50.00</p>
                </div>
                <div class="amount_container">
                    <div class="select_amount">
                        <div class="amount">
                            <button>RM 10</button>
                        </div>
                        <div class="amount">
                            <button>RM 20</button>
                        </div>
                        <div class="amount">
                            <button>RM 50</button>
                        </div>
                    </div>
                    <div class="select_amount">
                        <div class="amount">
                            <button>RM 100</button>
                        </div>
                        <div class="amount">
                            <button>RM 200</button>
                        </div>
                        <div class="amount">
                            <button>RM 500</button>
                        </div>
                    </div>
                </div>
                <p class="owner">Owned by SEWA Malaysia SDN. BHD.</p>
            </div>
        </div>
        <div class="booking_details">
            <div class="car_word">
                <p>Great Choice!</p>
                <h4>Seems like you have found your perfect car!</h4>
            </div>
            <div class="car_details">
                <div class="car_image">
                    <img src="https://drive.google.com/uc?export=view&id=13RyWd-Ddv-JafxBqmeBXoSbuek2rYeeK" alt="">
                </div>
                <div class="car_info">
                    <h1><%=vehicle.getV_brand()%> <%=vehicle.getV_model()%></h1>
                    <p>RM <%=vehicle.getRental_pr_hr() %>/hour</p>
                    <h3><%=vehicle.getDescription() %></h3>
                    <div class="price_guarantee">
                        <p>Best Price Guarantee</p>
                    </div>
                    <div class="car_spec">
                        <div class="spec_1">
                            <div class="spec_1_0">
                                <p>Brand</p>
                                <p>Model</p>
                                <p>Type</p>
                            </div>
                            <div class="spec_1_1">
                                <p><%=vehicle.getV_brand() %></p>
				                <p><%=vehicle.getV_model() %></p>
				                <p><%=vehicle.getV_type() %></p>
                            </div>
                        </div>
                        <div class="spec_2">
                            <div class="spec_2_0">
                                <p>Fuel Type</p>
                                <p>Capacity</p>
                                <p>Transmission</p>
                            </div>
                            <div class="spec_2_1">
                                <p>Diesel</p>
                                <p>5 Seaters</p>
                                <p>Automatic</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <hr>
            <div class="book_details">
                <div class="personal_details">
                    <p>Booking Details</p>
                    <!--  -->
                    <form method="get" action="ConfirmBookingController">
	                    <div class="form_row">
	                        <div class="form_box">
	                            <span class="form_indicator"><h4>Pickup Location <span class="form_mark">*</span></h4></span>
	                            <div class="input_form">
	                                <input type="text" placeholder="Pickup Location" name="pickup_location" required>
	                            </div>
	                        </div>
	                        <div class="form_box">
	                            <span class="form_indicator"><h4>Drop Location <span class="form_mark">*</span></h4></span>
	                            <div class="input_form">
	                                <input type="text" placeholder="Drop Location" required>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="form_row">
	                        <div class="form_box">
	                            <span class="form_indicator"><h4>Pickup Date <span class="form_mark">*</span></h4></span>
	                            <div class="input_form">
	                                <input type="date"  placeholder="Pickup Date" required>
	                            </div>
	                        </div>
	                        <div class="form_box">
	                            <span class="form_indicator"><h4>Drop Date <span class="form_mark">*</span></h4></span>
	                            <div class="input_form">
	                                <input type="date" placeholder="Drop Date" required>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="form_row">
	                        <div class="form_box">
	                            <span class="form_indicator"><h4>Number of Passenger <span class="form_mark">*</span></h4></span>
	                            <div class="input_form">
	                                <input type="text" placeholder="No. of Passenger" required>
	                            </div>
	                        </div>
	                        <div class="form_box">
	                            <span class="form_indicator"><h4>Rental Charge </h4></span>
	                            <div class="input_form">
	                                <input type="text" placeholder="RM 12.00" required disabled>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="form_row">
	                        <div class="form_box">
	                            <span class="form_indicator"><h4>Special Request</h4></span>
	                            <div class="input_form">
	                                <textarea class="special_request" name="special_request" placeholder="Special Request">
	                                </textarea>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="form_row">
	                        <div class="form_tnc">
	                            <input type="radio" id="tnc" name="term_condition" value="tnc">
	                            <label for="debit">Agree to our terms and conditions</label><br>
	                        </div>
	                    </div>
	                    <div class="proceed">
	                        <button type="submit">Proceed<i class="fa fa-chevron-right"></i></button>
	                    </div>
	                </form>
                    <!--  -->
                </div>
            </div>
        </div>
    </section>
    <section class="test2">
        <div class="recommend_word">
            <p>More For You</p>
            <h4>Feel free to view another car until you find the perfect one!</h4>
        </div>
        <div class="recommend">
            <div class="recommend-details">
                <h3>Vehicle 1</h3>
            </div>
            <button class="recommend-button">More info</button>
        </div>
        <div class="recommend">
            <div class="recommend-details">
                <h3>Vehicle 1</h3>
            </div>
            <button class="recommend-button">More info</button>
        </div>
        <div class="recommend">
            <div class="recommend-details">
                <h3>Vehicle 1</h3>
            </div>
            <button class="recommend-button">More info</button>
        </div>
    </section>

    <script src="booking.js"></script>
</body>
</html>