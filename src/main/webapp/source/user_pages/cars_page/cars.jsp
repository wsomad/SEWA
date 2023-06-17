<%@page import = "java.util.List, system.model.*" %>
<!DOCTYPE html>
<html lang="en">
<style>
	<%@include file="cars.css"%>
</style>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="cars.css">
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
                    <li><a href="#"><i class='bx bx-user-circle profile-icon' onclick="toggleMenu()"></i></a></li>
                </div>
            </ul>

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
        <div class="booking_car">
            <div class="booking_word">
                <p>From Over 50 Cars, Choose Yours!</p>
                <h4>Find your perfect car here. </h4>
            </div>
            <div class="booking_row">
            
            <%
	            List<Vehicle> vehicleList = (List<Vehicle>) session.getAttribute("dashboardContent");
				
				// Display each recommendation as a clickable panel
				for (Vehicle vehicle : vehicleList) { System.out.println("row");
            %>
                <div class="booking_container">
                    <div class="booking_details">
                        <div class="car_image">
                            <img src="https://drive.google.com/uc?export=view&id=1cs19Dr4j-sI_380xEyuakdWcKdUj5cY8" alt="">
                        </div>
                    </div>
                    <div class="car_name">
                        <p class="book_title">Volkswagen Arteon</p>
                    </div>
                    <div class="features_container">
                        <p>Features</p>
                        <div class="features">
                            <div class="features_box">
                                <div class="features_info">
                                    <i class="fa fa-car"></i>
                                </div>
                                <div class="features_type">
                                    <p>Sedan</p>
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
                        <p class="book_rate">RM 112.00 <span>per day</span> </p>
                    </div>
                    <button class="booking_button">Book Now</button>
                </div>
            <%
				}
            %>
              
            </div>
        </div>
    </section>
    <script src="cars.js"></script>
</body>
</html>