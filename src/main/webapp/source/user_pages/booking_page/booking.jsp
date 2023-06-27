<%@page import = "system.model.*" %>
<%
Vehicle vehicle = (Vehicle) request.getSession().getAttribute("vehicleInForm");
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
            <a href="../dashboard_page/user-dashboard.html" ><img src="https://drive.google.com/uc?export=view&id=1hnKz5R1P7uMvl4c2qAnSFUHrdH4Sy41B" class="nav_logo"></a>
            <ul class="nav_items">
                <li><a href="../dashboard_page/user-dashboard.html" class="nav_link">Home</a></li>
                <li>
                    <a href="" class="nav_link" id="service-link">Service</a>
                    <ul class="sub_nav_link" id="service-dropdown"> 
                        <li><a href="">Car Rental</a></li>
                        <li><a href="../p2p_page/p2p-register.html">Rent as Peer</a></li>
                    </ul>
                </li>
                <li><a href="car.html" class="nav_link">Our Cars</a></li>
            </ul>         
            <ul>
                <div class="wallet_profile">
                    <li><a href="#"><i class='bx bx-wallet-alt wallet_show'></i></a></li>
                    <li><a href="#">
                            <div class="notification_badge">
                                <i class="fa fa-bell notification_bell" onclick="toggleNotification()"></i>
                                <span class="notification_number">2</span>
                            </div>
                        </a>
                    </li>
                    <li><a href="#"><i class='bx bx-user-circle profile_icon' onclick="toggleMenu()"></i></a></li>
                </div>
            </ul>

            <!-- notification bell -->
            <div class="notification_menu" id="notificationMenu">
                <div class="notification_word">
                    <h2>Notification</h2>
                </div>
                <div class="notification_item">
                    <a href="">
                        <div class="notification_row">
                            <h4>Accept Vehicle</h4>
                            <p>New Update on Booking: <span>Passat [ALK8704]</span></p>
                        </div>
                    </a>
                </div>
                <div class="notification_item">
                    <a href="">
                        <div class="notification_row">
                            <h4>Return Vehicle</h4>
                            <p>New Update on Booking: <span>Passat [ALK8704]</span></p>
                        </div>
                    </a>
                </div>
                <div class="notification_item">
                    <a href="">
                        <div class="notification_row">
                            <h4>Refund Request</h4>
                            <p>New Update on Booking: <span>Myvi [PKL2019]</span></p>
                        </div>
                    </a>
                </div>
                <div class="notification_item">
                    <a href="">
                        <div class="notification_row">
                            <h4>Accept Vehicle</h4>
                            <p>New Update on Booking: <span>Passat [ALK8704]</span></p>
                        </div>
                    </a>
                </div>
                <div class="notification_item">
                    <a href="">
                        <div class="notification_row">
                            <h4>Return Vehicle</h4>
                            <p>New Update on Booking: <span>Arteon [BGU2264]</span></p>
                        </div>
                    </a>
                </div>
                <div class="notification_item">
                    <a href="">
                        <div class="notification_row">
                            <h4>Refund Request</h4>
                            <p>New Update on Booking: <span>Myvi [PKL2019]</span></p>
                        </div>
                    </a>
                </div>
            </div>

            <!-- sub menu -->
            <div class="sub-menu-wrap" id="subMenu">
                <div class="sub-menu">
                    <div class="user-info">
                         <h2>Hello user</h2>
                    </div>
                    <a href="a" class="sub-menu-link">
                        <i class='bx bx-user-circle'></i>
                            <p>Profile</p>
                    </a>
                    <a href="a" class="sub-menu-link">
                        <i class='bx bx-cog'></i>
                            <p>Setting</p>
                    </a>
                    <a href="a" class="sub-menu-link">
                        <i class='bx bx-log-out' ></i>
                            <p>Sign out</p>
                    </a>
                    <div class="owner_name">
                        <p class="owner">Owned by SEWA Malaysia SDN. BHD.</p>
                    </div>
                </div>
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
                <p>Start Booking</p>
                <div class="personal_details">
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
		                        	<input type="text" placeholder="Drop Location" name="drop_location" required>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="form_row">
	                        <div class="form_box">
	                            <span class="form_indicator"><h4>Pickup Date <span class="form_mark">*</span></h4></span>
	                            <div class="input_form">
		                        	<input type="date"  placeholder="Pickup Date" name="pickup_date" id="pickup_date" required>
	                            </div>
	                        </div>
	                        <div class="form_box">
	                            <span class="form_indicator"><h4>Drop Date <span class="form_mark">*</span></h4></span>
	                            <div class="input_form">
		                        	<input type="date" placeholder="Drop Date" name="drop_date" id="drop_date" required>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="form_row">
	                        <div class="form_box">
	                            <span class="form_indicator"><h4>Number of Passenger <span class="form_mark">*</span></h4></span>
	                            <div class="input_form">
		                        	<input type="text" placeholder="No. of Passenger" name="passengers_num" required>
	                            </div>
	                        </div>
	                        <div class="form_box">
	                            <span class="form_indicator"><h4>Rental Charge </h4></span>
	                            <div class="input_form">
	                           		<input type="text" value="RM 0.00" placeholder="RM 0.00" name="rental_charge" id="rental_charge" required readonly>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="form_row">
	                        <div class="form_box">
	                            <span class="form_indicator"><h4>Special Request</h4></span>
	                            <div class="input_form">
	                                <textarea class="special_request" name="special_request" placeholder="Special Request"></textarea>
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
	                        <button>Proceed<i class="fa fa-chevron-right"></i></button>
	                    </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
    <section class="test2">
        <div class="recommend_container">
            <div class="recommend_word">
                <p>More For You</p>
                <h4>Feel free to view another car until you find the perfect one!</h4>
            </div>
            <div class="recommend_row">
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
            </div>
        </div>
    </section>

    <script src="booking.js"></script>
    <script>
    	var pickupDate = document.getElementById("pickup_date");
    	var dropDate = document.getElementById("drop_date");
    	var rentalChrg = document.getElementById("rental_charge");
    	
    	function calculateRentalCharge(){
    		var pickup = new Date(pickupDate.value);
    		var drop = new Date (dropDate.value);
    		
    		//Rental charge calculation
    		var numDays = drop.getTime() - pickup.getTime();
    		numDays = Math.ceil(numDays/(1000*60*60*24));
    		var rentalChg = numDays * 24 * <%=vehicle.getRental_pr_hr()%>;
    		
    		//Set the rentalCharge on txtBox
    		rentalChrg.value = isNaN(rentalChg) ? "":"RM "+rentalChg;
    	}
    	
    	//Event listeners to calculate the rental charge whenever the input change
    	pickupDate.addEventListener("input", calculateRentalCharge);
    	dropDate.addEventListener("input", calculateRentalCharge);
    </script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            
            $('#drop_date').change(function() {
                var dropDate = $(this).val();
                
                $.ajax({
                    url: 'CheckDropDateServlet',
                    type: 'POST',
                    data: { dropDate: dropDate},
                    success: function(response) {
                        $('#message').text(response);
                    }
                });
            });
        });
    </script>
    <div id="message"></div>
</body>
</html>