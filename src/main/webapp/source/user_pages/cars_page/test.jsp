<!DOCTYPE html>
<html>
<head>
  <title>Dashboard</title>
  <style>
    body {
      font-family: Arial, sans-serif;
    }

    .card-container {
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;
    }

    .card {
      width: 300px;
      margin-bottom: 20px;
      padding: 20px;
      border: 1px solid #ccc;
      border-radius: 5px;
      cursor: pointer;
      transition: box-shadow 0.3s;
    }

    .card:hover {
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    .card-img {
      width: 100%;
      height: 200px;
      object-fit: cover;
      border-radius: 5px;
      margin-bottom: 10px;
    }

    .card-title {
      font-size: 20px;
      font-weight: bold;
      margin-bottom: 10px;
    }
  </style>
</head>
<body>
  <h1>Dashboard</h1>

  <div class="card-container">
    <%@ page import="system.model.Vehicle" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%-- Retrieve the list of vehicles from the session --%>
    <c:set var="vehicleList" value="${session.getAttribute('dashboardContent')}"/>

    <%-- Check if the vehicle list is not empty --%>
    <c:if test="${not empty vehicleList}">
      <%-- Iterate over the vehicle list and display each car as a card --%>
      <c:forEach var="vehicle" items="${vehicleList}">
        <div class="card" onclick="redirectToBookingPage(${vehicle})">
          <img class="card-img" src="${vehicle.getImg_path()}" alt="Car Image">
          <h2 class="card-title">${vehicle.getV_model()}</h2>
        </div>
      </c:forEach>
    </c:if>
  </div>

  <script>
    function redirectToBookingPage(vehicle) {
      // Convert the vehicle object to a JSON string
      var vehicleJson = JSON.stringify(vehicle);

      // Encode the JSON string to be passed as a query parameter
      var encodedVehicleJson = encodeURIComponent(vehicleJson);

      // Redirect to the booking form page and pass the vehicle object as a query parameter
      window.location.href = "booking.jsp?vehicle=" + encodedVehicleJson;
    }
  </script>
</body>
</html>
