<%@page import="system.model.Activity, java.util.Stack, java.time.LocalDate, java.time.LocalDateTime, java.time.temporal.ChronoUnit" %>
<%
Stack<Activity> activities = (Stack<Activity>) request.getSession().getAttribute("activities");

%>
<!-- hh -->
<!DOCTYPE html>
<html lang="en">
<style>
	<%@include file="record.css"%>
</style>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="record.css">
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

    <section class="home2">
        <div class="activity">
            <p>Record & Activities</p>
            <div class="activity_container">
            
<!-- ===================================================================================================================== -->
            <!-- If Statement (within this week) -->
          <%--if () --%> 
                <div class="date_bar">
                    <p>Last Month</p>
                    <div class="horizontal_line"></div>
                </div>
                <!-- While Statement () -->
	                <div class="booking_container">
	                    <div class="car_image">
	                        <img src="https://drive.google.com/uc?export=view&id=1cs19Dr4j-sI_380xEyuakdWcKdUj5cY8" alt="">
	                    </div>
	                    <div class="booked_car">
	                        <div class="car_info">
	                            <div class="info_details">
	                                <div class="details">
	                                    <h4>Brand</h4>
	                                    <p>Mercedes</p>
	                                </div>
	                                <div class="details">
	                                    <h4>Start Date</h4>
	                                    <p>20/2/2022</p>
	                                </div>
	                            </div>
	                            <div class="info_details">
	                                <div class="details">
	                                    <h4>Model</h4>
	                                    <p>Passat</p>
	                                </div>
	                                <div class="details">
	                                    <h4>Return Date</h4>
	                                    <p>23/2/2022</p>
	                                </div> 
	                            </div>
	                            <div class="info_details">
	                                <div class="details">
	                                    <h4>Reg. Number</h4>
	                                    <p>ALK8704</p>
	                                </div>
	                                <div class="details">
	                                    <h4>Pickup Place</h4>
	                                    <p>Pulau Pinang</p>
	                                </div>
	                            </div>
	                            <div class="info_details">
	                                <div class="details">
	                                    <h4>Rental Fee</h4>
	                                    <p>RM 400.00</p>
	                                </div>
	                                <div class="details">
	                                    <h4>Drop Place</h4>
	                                    <p>Kedah</p>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="activity_button">
	                            <button>Reschedule</button>
	                            <button>Cancel</button>
	                        </div>
	                    </div>
	                </div>
                <!-- close while statement -->
            <!-- close if statement -->
<!-- ===================================================================================================================== -->
            <!-- If Statement (within this month) -->
                <div class="date_bar">
                    <p>Last Month</p>
                    <div class="horizontal_line"></div>
                </div>
                <!-- While Statement () -->
	                <div class="booking_container">
	                    <div class="car_image">
	                        <img src="https://drive.google.com/uc?export=view&id=1cs19Dr4j-sI_380xEyuakdWcKdUj5cY8" alt="">
	                    </div>
	                    <div class="booked_car">
	                        <div class="car_info">
	                            <div class="info_details">
	                                <div class="details">
	                                    <h4>Brand</h4>
	                                    <p>Mercedes</p>
	                                </div>
	                                <div class="details">
	                                    <h4>Start Date</h4>
	                                    <p>20/2/2022</p>
	                                </div>
	                            </div>
	                            <div class="info_details">
	                                <div class="details">
	                                    <h4>Model</h4>
	                                    <p>Passat</p>
	                                </div>
	                                <div class="details">
	                                    <h4>Return Date</h4>
	                                    <p>23/2/2022</p>
	                                </div> 
	                            </div>
	                            <div class="info_details">
	                                <div class="details">
	                                    <h4>Reg. Number</h4>
	                                    <p>ALK8704</p>
	                                </div>
	                                <div class="details">
	                                    <h4>Pickup Place</h4>
	                                    <p>Pulau Pinang</p>
	                                </div>
	                            </div>
	                            <div class="info_details">
	                                <div class="details">
	                                    <h4>Rental Fee</h4>
	                                    <p>RM 400.00</p>
	                                </div>
	                                <div class="details">
	                                    <h4>Drop Place</h4>
	                                    <p>Kedah</p>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="activity_button">
	                            <button>Reschedule</button>
	                            <button>Cancel</button>
	                        </div>
	                    </div>
	                </div>
                <!-- close while statement -->
            <!-- close if statement -->
<!-- ===================================================================================================================== -->
            <!-- If Statement (within last month and bfore) -->
                <div class="date_bar">
                    <p>Last Month</p>
                    <div class="horizontal_line"></div>
                </div>
                <!-- While Statement () -->
	                <div class="booking_container">
	                    <div class="car_image">
	                        <img src="https://drive.google.com/uc?export=view&id=1cs19Dr4j-sI_380xEyuakdWcKdUj5cY8" alt="">
	                    </div>
	                    <div class="booked_car">
	                        <div class="car_info">
	                            <div class="info_details">
	                                <div class="details">
	                                    <h4>Brand</h4>
	                                    <p>Mercedes</p>
	                                </div>
	                                <div class="details">
	                                    <h4>Start Date</h4>
	                                    <p>20/2/2022</p>
	                                </div>
	                            </div>
	                            <div class="info_details">
	                                <div class="details">
	                                    <h4>Model</h4>
	                                    <p>Passat</p>
	                                </div>
	                                <div class="details">
	                                    <h4>Return Date</h4>
	                                    <p>23/2/2022</p>
	                                </div> 
	                            </div>
	                            <div class="info_details">
	                                <div class="details">
	                                    <h4>Reg. Number</h4>
	                                    <p>ALK8704</p>
	                                </div>
	                                <div class="details">
	                                    <h4>Pickup Place</h4>
	                                    <p>Pulau Pinang</p>
	                                </div>
	                            </div>
	                            <div class="info_details">
	                                <div class="details">
	                                    <h4>Rental Fee</h4>
	                                    <p>RM 400.00</p>
	                                </div>
	                                <div class="details">
	                                    <h4>Drop Place</h4>
	                                    <p>Kedah</p>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="activity_button">
	                            <button>Reschedule</button>
	                            <button>Cancel</button>
	                        </div>
	                    </div>
	                </div>
                <!-- close while statement -->
            <!-- close if statement -->
<!-- ===================================================================================================================== -->
            </div>
        </div>
    </section>

    <script src="record.js"></script>
</body>
</html>