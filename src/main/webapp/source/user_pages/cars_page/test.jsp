<%@page import = "java.util.List, system.model.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Recommendations</title>
	<style>
		.panel {
			display: inline-block;
			margin: 10px;
			padding: 10px;
			border: 1px solid #ccc;
			text-align: center;
			cursor: pointer;
			width: 200px;
			height: 200px;
			overflow: hidden;
		}
		.panel img {
			max-width: 100%;
			max-height: 100%;
			object-fit: contain;
		}
	</style>
</head>
<body>
	<h1>Recommendations</h1>
	<p>Click on a panel to view the product details:</p>
	<div>
		<%
			// Retrieve recommendations from the database
			List<Vehicle> vehicleList = (List<Vehicle>) session.getAttribute("dashboardContent");
			
			// Display each recommendation as a clickable panel
			for (Vehicle vehicle : vehicleList) {
		%>
			<div class="panel">
				<img src="<%= vehicle.getImg_path() %>">
				<p><%= vehicle.getV_model() %></p>
				<form method="POST" action="BookingController">
					<input type="hidden" name="vehicleId" value="<%= vehicle.getVehicleid() %>">
					<button type="submit">Book Now</button>
				</form>
			</div>
		<%
			}
		%>
	</div>
</body>
</html>
