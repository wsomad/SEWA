<%@page import="system.model.*, java.util.List"%>
<%
List<Activity> orderhistories = (List<Activity>) session.getAttribute("listOfOrderHistory");
for (Activity orderhistory : orderhistories){
	System.out.println(orderhistory.getReservation().getReservation_userid() + "---" + orderhistory.getReservation().getReservation_vehicleid());
}
%>
<style>
	<%@include file="admin-dashboard.css"%>
</style>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Boxicons CSS -->
    <link rel="stylesheet" href="admin-dashboard.css">
    <link rel="icon" type="images/png" href="https://drive.google.com/uc?export=view&id=1WnCOPug2C25vqv-_nxG6QvVp2VSMVnp1">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">


    <title>User-dashboard</title>
    <title>sidebar</title>
</head>
<body>
    <div class="sidebar">
        <div class="nav">
            <ul>
                <li>
                    <a href="a">
                        <span class="icon"><img src="\src\main\webapp\source\images\footer.png" class="nav_logo"></span>
                        <span class="title">SEWA</span>
                    </a>
                </li>
                <li>
                    <a href="https://www.youtube.com/watch?v=lhNpH7oNvPY&pp=ygUPYW5kYSBrZW5hIHByYW5r">
                        <span class="icon"><i class='bx bx-user'></i></span>
                        <span class="title">Admin dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="a">
                        <span class="icon"><i class='bx bxs-car'></i></span>
                        <span class="title">Car Inventory</span>
                    </a>
                </li>
                <li>
                    <a href="a">
                        <span class="icon"><i class='bx bx-line-chart'></i></span>
                        <span class="title">Profit Insight</span>
                    </a>
                </li>
                <li>
                    <a href="a">
                        <span class="icon"><i class='bx bxs-bar-chart-alt-2' ></i></span>
                        <span class="title">Car Insight</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>


    <!-- main -->
    <div class="main-div">
        <div class="topbar">
            <div class="toggle">
                <i class='bx bx-menu'></i>
            </div>
             <!-- search -->
                <div class="search">
                    <label>
                        <input type="text" placeholder="Search here">
                        <i class='bx bx-search-alt-2'></i>
                    </label>
                </div>
             <!-- user img -->
             <div class="right_top">
             <div class="icon" onclick="toggleNotifi()">
                <ion-icon name="notifications-outline"></ion-icon><span>17</span>
                    </div>
                    <div class="notifi-box" id="box">
                        <h2>Notifications <span>17</span></h2>
                        <div class="notifi-item">
                            <img src="avatar1.png" alt="img">
                            <div class="text">
                               <h4>Elias Abdurrahman</h4>
                               <p>@lorem ipsum dolor sit amet</p>
                            </div> 
                        </div>
            
                        <div class="notifi-item">
                            <img src="img/avatar2.png" alt="img">
                            <div class="text">
                               <h4>John Doe</h4>
                               <p>@lorem ipsum dolor sit amet</p>
                            </div> 
                        </div>
            
                        <div class="notifi-item">
                            <img src="img/avatar3.png" alt="img">
                            <div class="text">
                               <h4>Emad Ali</h4>
                               <p>@lorem ipsum dolor sit amet</p>
                            </div> 
                        </div>
            
                        <div class="notifi-item">
                            <img src="img/avatar4.png" alt="img">
                            <div class="text">
                               <h4>Ekram Abu </h4>
                               <p>@lorem ipsum dolor sit amet</p>
                            </div> 
                        </div>
            
                        <div class="notifi-item">
                            <img src="img/avatar5.png" alt="img">
                            <div class="text">
                               <h4>Jane Doe</h4>
                               <p>@lorem ipsum dolor sit amet</p>
                            </div> 
                        </div>
            
                    </div>
                <div class="user">
                    <i class='bx bx-user-circle profile-icon' onclick="toggleMenu()"></i>
                </div></div>
                
                    
        </div>
        <!-- submenu -->
        <div class="sub-menu-wrap" id="subMenu">
            <div class="sub-menu">
                <div class="user-info">
                     <h2>Hello user</h2>
                </div>
                <a href="a" class="sub-menu-link">
                    <i class='bx bxs-edit'></i>
                        <p>Edit profile</p>
                </a>
                <a href="a" class="sub-menu-link">
                    <i class='bx bx-cog'></i>
                        <p>Setting</p>
                </a>
                <a href="a" class="sub-menu-link">
                    <i class='bx bx-log-out' ></i>
                        <p>Log out</p>
                </a>
            </div>
        </div>
        <!-- start code here -->
        <!-- card box-->
        <div class="cardBox">
            <div class="card">
                <div>
                    <div class="numbers">200</div>
                    <div class="cardName">Total users</div>
                </div>
                <div class="iconBx"><ion-icon name="people"></ion-icon></div>
            </div>
            <div class="card">
                <div>
                    <div class="numbers">200</div>
                    <div class="cardName">Total Cars</div>
                </div>
                <div class="iconBx"><ion-icon name="car"></ion-icon></div>
            </div>
            <div class="card">
                <div>
                    <div class="numbers">200</div>
                    <div class="cardName">Total Reservation</div>
                </div>
                <div class="iconBx"><ion-icon name="cart"></ion-icon></div>
            </div>
            <div class="card">
                <div>
                    <div class="numbers">200</div>
                    <div class="cardName">Profit</div>
                </div>
                <div class="iconBx"><ion-icon name="trending-up"></ion-icon></div>
            </div>

            <!-- table -->
            <div class="details">
                <div class="recentOrders">
                    <div class="cardHeader">
                        <h2>Order History</h2>
                    </div>
                    <section class="header">
                    <div class="items-controller">
                    <h5>Show</h5>
                    <select name="" id="itemperpage">
                    <option value="04">04</option>
                    <option value="05">05</option>
                    <option value="08"selected>08</option>
                    <option value="10">10</option>
                    <option value="15">15</option>
                    </select>
                    <h5>Per Page</h5>
                    </div>
                    </section>
                    <section id="field">
                    <table id="orders">
                        <thead>
                            <tr>
                                <td>Name</td>
                                <td>Vehicle ID</td>
                                <td>Pickup Date</td>
                                <td>Drop Date</td>
                                <td>Rent to Pay</td>
                                <td>Status</td>
                            </tr>
                        </thead>
                        <tbody>
                        	<%for(Activity orderhistory : orderhistories){%>
                        		<tr>
	                                <td><%=orderhistory.getUser().getUser_first_name() %></td>
	                                <td><%=orderhistory.getVehicle().getRegistration_num() %></td>
	                                <td><%=orderhistory.getReservation().getPickup_DateString() %></td>
	                                <td><%=orderhistory.getReservation().getDrop_DateString() %></td>
	                                <td><%=orderhistory.getReservation().getRent_to_pay() %></td>
	                                <td><span class="renting">Renting</span></td>
	                            </tr>
                        	<%}%>
                        </tbody>
                    </table>
                    </section>
                    <div class="bottom-field">
                    	<ul class="pagination">
                    		<li class="prev"><a href="#" id="prev">&#139;</a></li>
                    		
                    		<li class="next"><a href="#" id="next">&#155;</a></li>
                    	</ul>
                    </div>
                </div>
            </div>


        </div>
    </div>
    
        <script type="text/javascript" src="admin-dashboard.js"></script>
        <script>
	        const formOpenButton = document.querySelector("#form-open"),
	        home = document.querySelector(".home2"),
	        formContainer = document.querySelector(".form_container2"),
	        formCloseButton = document.querySelector(".form_close"),
	        loginButton = document.querySelector("#login"),
	        pwShowHide = document.querySelectorAll(".pw_hide");
	
	        formOpenButton.addEventListener("click", () => home.classList.add("show"))
	        formCloseButton.addEventListener("click", () => home.classList.remove("show"))
	
	        pwShowHide.forEach(icon => {
	            icon.addEventListener("click", () => {
	                let getPwInput = icon.parentElement.querySelector("input");
	                if(getPwInput.type === "password") {
	                    getPwInput.type = "text";
	                    icon.classList.replace("fa-eye-slash", "fa-eye");
	                }
	                else {
	                    getPwInput.type = "password";
	                    icon.classList.replace("fa-eye", "fa-eye-slash");
	                }
	            })
	        })
	
	        loginButton.addEventListener("click", (e) => {
	            e.preventDefault();
	            formContainer.classList.remove("active");
	        });
        </script>
        <script src="https://unpkg.com/ionicons@4.5.10-0/dist/ionicons.js"></script>

</body>
</html>

