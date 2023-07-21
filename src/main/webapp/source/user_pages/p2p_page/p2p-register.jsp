<%@page import = "system.model.*" %>
<%
Vehicle vehicle = (Vehicle) request.getSession().getAttribute("vehicleAtt");
boolean flag = false;
String servlet_url= "";
if(vehicle != null){
	servlet_url = "AdminAlterationController";
	flag = true;
}else{
	servlet_url = "p2p-registerController";
}
%>
<!DOCTYPE html>
<html lang="en">
<style>
	<%@include file="p2p-register.css"%>
</style>
<script type="text/javascript" src="../p2p_page/p2p-register.js"></script>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="p2p-register.css">
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
    
    <section class="home">
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
    </section>
    
    <section class="register_form">
        <div class="peer_title">
            <p>Become Our Peer Now!</p>
        </div>
        <div class="peer_word">
            <p> By becoming one of our peer, you can earn some income when customer booked your car! </p>
        </div>
        <div class="form_container">
            <div class="form_title">
                <p>Rent as Peer</p>
            </div>
            <form method="post" action="<%=servlet_url%>" enctype="multipart/form-data">
             
                <div class="form_row">
                    <div class="form_box">
                        <span class="form_indicator"><h4>Brand <span class="form_mark">*</span></h4></span>
                        <%if(flag){ System.out.println("before : " + vehicle.getV_brand());%>
	                        <div class="input_form">
	                            <input type="text" placeholder="Brand" value="<%=vehicle.getV_brand() %>" name="brand" required>
	                        </div>
                        <%}else{ %>
	                        <div class="input_form">
	                            <input type="text" placeholder="Brand" name="brand" required>
	                        </div>
                        <%} %>
                        
                    </div>
                    <div class="form_box">
                        <span class="form_indicator"><h4>Model <span class="form_mark">*</span></h4></span>
                        <%if(flag){ %>
                        <div class="input_form">
                            <input type="text" placeholder="Model" value="<%=vehicle.getV_model() %>" name="model" required>
                        </div>
                        <%}else{ %>
                        <div class="input_form">
                            <input type="text" placeholder="Model" name="model" required>
                        </div>
                        <%} %>
                    </div>
                </div>
            
                <div class="form_row">
                    <div class="form_box">
                        <span class="form_indicator"><h4>Type <span class="form_mark">*</span></h4></span>
                        <% if(flag){%>
                        <div class="input_form">
                            <input type="text" placeholder="Type" value="<%=vehicle.getV_type() %>" name="type" required>
                        </div>
                        <%}else{ %>
                        <div class="input_form">
                            <input type="text" placeholder="Type" name="type" required>
                        </div>
                        <%} %>
                    </div>
                    <div class="form_box">
                        <span class="form_indicator"><h4>Year Manufactured  <span class="form_mark">*</span></h4></span>
                        <% if(flag){%>
                        <div class="input_form">
                            <input type="text" placeholder="Year Manufactured" value="<%=vehicle.getYr_manufacture() %>" name="yearManufactured" required>
                        </div>
                        <%} else{%>
                        <div class="input_form">
                            <input type="text" placeholder="Year Manufactured" name="yearManufactured" required>
                        </div>
                        <%} %>
                    </div>
                </div>
                <div class="form_row">
                    <div class="form_box">
                        <span class="form_indicator"><h4>Type of Gas <span class="form_mark">*</span></h4></span>
                        <% if(flag){%>
                        <div class="input_form">
                            <input type="text" placeholder="Type of Gas" value="<%=vehicle.getGasType() %>" name="gasType" required>
                        </div>
                        <%}else{ %>
                        <div class="input_form">
                            <input type="text" placeholder="Type of Gas" name="gasType" required>
                        </div>
                        <%} %>
                    </div>
                    <div class="form_box">
                        <span class="form_indicator"><h4>Number of Seater  <span class="form_mark">*</span></h4></span>
                         <% if(flag){%>
                         <div class="input_form">
                            <input type="text" placeholder="No. of Seater" value="<%=vehicle.getSeatNum() %>" name="numberOfSeater" required>
                        </div>
                         <%}else{ %>
                        <div class="input_form">
                            <input type="text" placeholder="No. of Seater" name="numberOfSeater" required>
                        </div>
                        <%} %>
                    </div>
                </div>
                <div class="form_row">
                    <div class="form_box">
                        <span class="form_indicator"><h4>Transmission<span class="form_mark">*</span></h4></span>
                        <div class="input_form">
                            <select name="transmission" id="transmission" required>
                                <option value="none" selected disabled hidden>Transmission Type</option>
                                <option value="1">Automatic</option>
                                <option value="2">Manual</option>
                            </select>
                        </div>
                    </div>
                    <div class="form_box">
                        <span class="form_indicator"><h4>Registration Number <span class="form_mark">*</span></h4></span>
                        <% if(flag){%>
                        <div class="input_form">
                            <input type="text" placeholder="Registration Number" value="<%=vehicle.getRegistration_num() %>" name="registrationNumber" required>
                        </div>
                        <%}else{ %>
                        <div class="input_form">
                            <input type="text" placeholder="Registration Number" name="registrationNumber" required>
                        </div>
                        <%} %>
                    </div>
                </div>
                <div class="form_row">
                    <div class="form_box">
                        <span class="form_indicator"><h4>Roadtax Expiry Date <span class="form_mark">*</span></h4></span>
                        <%if(flag){ %>
                        <div class="input_form">
                            <input type="text" placeholder="Roadtax Expiry Date" value="<%=vehicle.getStringRoadtax_exp_date() %>" name="roadtaxExpiryDate" required>
                        </div>
                        <%}else{ %>
                        <div class="input_form">
                            <input type="text" placeholder="Roadtax Expiry Date" name="roadtaxExpiryDate" required>
                        </div>
                        <%} %>
                    </div>
                    <div class="form_box">
                        <span class="form_indicator"><h4>Engine Number <span class="form_mark">*</span></h4></span>
                        <%if(flag){ %>
                        <div class="input_form">
                            <input type="text" placeholder="Engine Number" value="<%=vehicle.getEngine_num() %>" name="engineNumber" required>
                        </div>
                        <%}else{ %>
                        <div class="input_form">
                            <input type="text" placeholder="Engine Number" name="engineNumber" required>
                        </div>
                        <%} %>
                    </div>
                    
                </div>
                <div class="form_row">
                    <div class="form_box">
                        <span class="form_indicator"><h4>Chasis Number <span class="form_mark">*</span></h4></span>
                        <%if(flag){ %>
                        <div class="input_form">
                            <input type="text" placeholder="Chasis Number" value="<%=vehicle.getChasis_num() %>" name="chasisNumber" required>
                        </div>
                        <%}else{ %>
                        <div class="input_form">
                            <input type="text" placeholder="Chasis Number" name="chasisNumber" required>
                        </div>
                        <%} %>
                    </div>
                    <div class="form_box">
                        <span class="form_indicator"><h4>Insurance Type<span class="form_mark">*</span></h4></span>
                        <div class="input_form">
                            <select name="insuranceType" id="insuranceType" required>
                                <option value="none" selected disabled hidden>Insurance Type</option>
                                <option value="1">1st Party</option>
                                <option value="2">3rd Party</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form_row">
                    <div class="form_box">
                        <span class="form_indicator"><h4>Insurance Name <span class="form_mark">*</span></h4></span>
                        <%if(flag) {%>
                        <div class="input_form">
                            <input type="text" placeholder="Insurance Name" value="<%=vehicle.getInsurance_name() %>" name="insuranceName" required>
                        </div>
                        <%}else{ %>
                        <div class="input_form">
                            <input type="text" placeholder="Insurance Name" name="insuranceName" required>
                        </div>
                        <%} %>
                    </div>
                    <div class="form_box">
                        <span class="form_indicator"><h4>Insurance Expiry Date <span class="form_mark">*</span></h4></span>
                        <%if(flag) {%>
                        <div class="input_form">
                            <input type="text" placeholder="Insurance Expiry Date" value="<%=vehicle.getStringInsurance_exp_date() %>" name="insuranceExpiryDate" required>
                        </div>
                        <%}else{ %>
                        <div class="input_form">
                            <input type="text" placeholder="Insurance Expiry Date" name="insuranceExpiryDate" required>
                        </div>
                        <%} %>
                    </div>
                </div>
                <div class="form_row">
                    <div class="form_box">
                        <span class="form_indicator"><h4>Choose Location <span class="form_mark">*</span></h4></span>
                        <div class="input_form">
                            <select name="location" id="location" required>
                                <option value="none" selected disabled hidden>Location</option>
                                <option value="1">Johor</option>
                                <option value="2">Klang Valley</option>
                                <option value="3">Melaka</option>
                                <option value="4">Perak</option>
                                <option value="5">Pulau Pinang</option>
                                <option value="6">Terengganu</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form_row">
                    <div class="form_box">
                        <span class="form_indicator"><h4>Set Rental Charge <span class="form_mark">*</span></h4></span>
                        <%if(flag){ %>
                        <div class="input_form">
                            <input type="text" placeholder="Set Rental Charge RM/hour" value="<%=vehicle.getRental_pr_hr() %>" name="rentalCharge" required>
                        </div>
                        <%}else{ %>
                        <div class="input_form">
                            <input type="text" placeholder="Set Rental Charge RM/hour" name="rentalCharge" required>
                        </div>
                        <%} %>
                    </div>
                </div>
                
               	<%if(!flag) {%>
                <div class="form_row">
                    <div class="form_box">
                        <span class="form_indicator"><h4>Upload Vehicle Image <span class="form_mark">*</span></h4></span>
                        <div class="upload_container">
                            <input class="file_upload" type="file" id="file" accept="image/*" name="car_img" required>
                        </div>
                    </div>
                </div>
                <%} %>
                
                <div class="register_button">
                    <button class="submit_button">Register</button>
                    <button class="cancel_button">Cancel</button>
                </div>
            </form>
        </div>

        <div class="information_message">
            <div class="reminder_word">
                <p><i class="fa fa-lightbulb"></i> Friendly Reminder</p>
            </div>
            <div class="reminder_sentence">
                <h4>Your registration might fail if road tax and insurance of your car is expired.</h4>
            </div>
        </div>
    </section>
    <section class="nothing">
        
    </section>
</body>
</html>