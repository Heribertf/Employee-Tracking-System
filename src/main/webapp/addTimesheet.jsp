<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
  }
  
  li {
    float: left;
  }
  
  li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
  }
  
  li a:hover {
    background-color: #111;
  }

  body, html {
    height: 100%;
    margin: 0;
    font-family: Arial, Helvetica, sans-serif;
  }
  .hero-image {
    background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("/resources/img/ems.webp");
    height: 100%;
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
    position: relative;


  }
  body {
  background-image: url('https://advancesystemsinc.com/wp-content/uploads/2016/08/Employee-Management-Software-for-Small-Business.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}
  
  .hero-text {
    text-align: center;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    color: white;
  }
  
  /* .hero-text button {
    border: none;
    outline: 0;
    display: inline-block;
    padding: 10px 25px;
    color: black;
    background-color: #ddd;
    text-align: center;
    cursor: pointer;
  }
  
  .hero-text button:hover {
    background-color: #555;
    color: white;
  } */
/*-----------------Modal----------------------*/
/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
  }
  
  /* Set a style for all buttons */
  button {
    background-color: #04AA6D;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
  }
  
  button:hover {
    opacity: 0.8;
  }
  
  /* Extra styles for the cancel button */
  .cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
  }
  
  /* Center the image and position the close button */
  .imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
    position: relative;
  }
  
  img.avatar {
    width: 30%;
    border-radius: 50%;
  }
  
  .container {
    padding: 16px;
  }
  
  span.psw {
    float: right;
    padding-top: 16px;
  }
  
  /* The Modal (background) */
  .modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    padding-top: 60px;
  }
  
  /* Modal Content/Box */
  .modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 80%; /* Could be more or less, depending on screen size */
  }
  
  /* The Close Button (x) */
  .close {
    position: absolute;
    right: 25px;
    top: 0;
    color: #000;
    font-size: 35px;
    font-weight: bold;
  }
  
  .close:hover,
  .close:focus {
    color: red;
    cursor: pointer;
  }
  
  /* Add Zoom Animation */
  .animate {
    -webkit-animation: animatezoom 0.6s;
    animation: animatezoom 0.6s
  }
  
  @-webkit-keyframes animatezoom {
    from {-webkit-transform: scale(0)} 
    to {-webkit-transform: scale(1)}
  }
    
  @keyframes animatezoom {
    from {transform: scale(0)} 
    to {transform: scale(1)}
  }
  
  /* Change styles for span and cancel button on extra small screens */
  @media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
  }
  /* View Leave css */
  .view-leave {
    text-align: center;
  }
</style>
</head>
<body>
 	<form action="TimesheetServlet" method="post">
    <h1 align="center">Add Timesheet</h1>
    <h1>
      <!--<a href="viewTimesheet.jsp">List Timesheets</a>-->
    </h1>
    <table border="1" align="center" cellpadding="5"
      style="font-size: 200%; font-family: inherit; font-style: normal; background-color: window;">
      <tr>
        <td>Employee No</td>
        <td><input type="text" name="empNo"></td>
      </tr>
      <tr>
        <td>Project Code</td>
        <td><input type="text" name="projectCode"></td>
      </tr>
      <tr>
        <td>Task Description</td>
        <td><input type="text" name="taskDescription"></td>
      </tr>
      <tr>
        <td>Total Working Hours</td>
        <td><input type="text" name="totalWorkingHours"></td>
      </tr>
      <tr>
        <td>Date</td>
        <td><input type="date" name="date"></td>
      </tr>
      <tr>
      <tr>
        <td>Status</td>
        <td>
        	<select name="status">
        		<option value="Not Verified">Not Verified</option>
        	</select>
        </td>
      </tr>
        <td></td>
        <td><input type="submit" name="Action" value="Submit Timesheet"></td>
      </tr>
    </table>
  </form>
</body>
</html>