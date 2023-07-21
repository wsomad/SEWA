<%@page import="system.model.*, java.util.List"%>
<%
List<Vehicle> vehicleList = (List<Vehicle>) session.getAttribute("ListOfVehicle");
%>
<!DOCTYPE html>
<html lang="en">
<style>
	<%@include file="Car-inv.css"%>
</style>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Boxicons CSS -->
    <link rel="stylesheet" href="Car-inv.css">
    <link rel="icon" type="images/png" href="https://drive.google.com/uc?export=view&id=1WnCOPug2C25vqv-_nxG6QvVp2VSMVnp1">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">


    <title>Inventory</title>
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
                    <a href="a">
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
<!-- Selection table -->  
<section>
    <br>
    <br>
</section>

<!-- table -->        
<div class="details">
    <div class="inventory">
        <div class="cardHeader" class="items-controller"  id="itemperpage" value="15">
            <h2>Inventory</h2>
        </div>
        <section id="field">
        <table id="orders">
            <thead>
                <tr>
                    <td>Vehicle ID</td>
                    <td>Registration Number</td>
                    <td>Brand</td>
                    <td>Model</td>
                    <td>Type</td>
                    <td>Colour</td>
                    <td>Action</td>
                </tr>
            </thead>
            
            <tbody>
                <%for(Vehicle vehicle : vehicleList) {%>
	                <tr>
	                    <td><%=vehicle.getVehicleid() %></td>
	                    <td><%=vehicle.getRegistration_num() %></td>
	                    <td><%=vehicle.getV_brand() %></td>
	                    <td><%=vehicle.getV_model() %></td>
	                    <td><%=vehicle.getV_type() %></td>
	                    <td><%=vehicle.getYr_manufacture() %></td>
	                    <td>
	                    	<form method="post" action="BookingController">
	                    		<input type="hidden" name="vehicleId" value="<%=vehicle.getVehicleid()%>">
	                    		<button><i class="fa fa-edit" style="font-size:18px"></i></button>
	                        	<button><i class="fa fa-trash" style="font-size:18px"></i></button>
	                      	</form>
	                    </td>
	                </tr>
	            <%} %>
            </tbody>
        </table>
        </section>
        <div class="bottom-field">
            <ul class="pagination">
                <li class="prev"><a href="#" id="prev">&#139;</a></li>
                
                <li class="next"><a href="#" id="next">&#155;</a></li>
            </ul>
<!----Button--->
                
                    <a href="webapp/register.html" class="button" id="button">ADD</a>
     
            </div>
        </div>
    </div>

</div>

        <script src="car-inv.js"></script>
        <script src="https://unpkg.com/ionicons@4.5.10-0/dist/ionicons.js"></script>
</body>
</html>